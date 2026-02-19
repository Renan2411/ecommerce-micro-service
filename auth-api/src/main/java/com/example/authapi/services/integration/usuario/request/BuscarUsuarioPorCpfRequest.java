package com.example.authapi.services.integration.usuario.request;

import com.example.authapi.exceptions.UsuarioIntegrationException;
import com.example.authapi.services.integration.usuario.responses.BuscarUsuarioPorCpfResponse;
import com.example.authapi.utils.EurekaClientUtils;
import com.example.authapi.utils.JsonUtils;
import com.example.authapi.utils.RequisicoesHttpUtils;
import com.example.authapi.utils.UrlBuilderUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class BuscarUsuarioPorCpfRequest {

    private final String PATH_BUSCAR_USUARIO_POR_CPF = "usuarios/cpf/%s";
    private final String APPLICATION_NAME = "user-api";
    private final EurekaClientUtils eurekaClientUtils;
    private final RequisicoesHttpUtils requisicoesHttpUtils;

    public BuscarUsuarioPorCpfResponse executar(String cpf) {
        String url = montarUrl(cpf);

        Request request = montarRequest(url);

        try (Response response = requisicoesHttpUtils.realizarRequisicao(request)) {
            requisicoesHttpUtils.handleResponseStatusError(response);
            return requisicoesHttpUtils.converterResposta(response, BuscarUsuarioPorCpfResponse.class);
        } catch (IOException e) {
            log.info("Erro ao buscar usuário: {}", e.getMessage());
            throw new UsuarioIntegrationException(String.format("Não foi possível buscar o usuário de cpf: %s", cpf));
        }
    }

    private String montarUrl(String cpf)  {
        return UrlBuilderUtils.Builder()
                .baseUrl(eurekaClientUtils.baseUrlApplication(APPLICATION_NAME))
                .path(String.format(PATH_BUSCAR_USUARIO_POR_CPF, cpf))
                .build();
    }

    private Request montarRequest(String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }

}
