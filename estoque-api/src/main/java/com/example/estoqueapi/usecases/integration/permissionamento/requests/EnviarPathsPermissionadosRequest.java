package com.example.estoqueapi.usecases.integration.permissionamento.requests;

import com.example.estoqueapi.entities.dto.RoutePermissionsDTO;
import com.example.estoqueapi.exceptions.generics.GenericValidationException;
import com.example.estoqueapi.utils.JsonUtils;
import com.example.estoqueapi.utils.RequisicoesHttpUtils;
import com.example.estoqueapi.utils.UrlBuilderUtils;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EnviarPathsPermissionadosRequest {

    private final String URL_PATH = "configuracao/permissoes";

    @Value("${gateway.url}")
    private String gatewayUrl;

    @Value("${gateway.token-permissoes}")
    private String tokenPermissoes;

    @Autowired
    private RequisicoesHttpUtils requisicoesHttpUtils;

    @Autowired
    private JsonUtils jsonUtils;

    @Autowired
    private RoutePermissionsDTO routePermissionsDTO;

    public void executar() {
        String path = criarUrl();

        Request request = criarRequest(path);

        try (Response response = requisicoesHttpUtils.realizarRequisicao(request)) {
            requisicoesHttpUtils.handleResponseStatusError(response);
        } catch (IOException e) {
            throw new GenericValidationException(e.getMessage());
        }
    }

    private String criarUrl() {
        return UrlBuilderUtils.Builder()
                .baseUrl(gatewayUrl)
                .path(URL_PATH)
                .build();
    }

    private Request criarRequest(String path) {
        RequestBody requestBody = RequestBody.create(jsonUtils.toJson(routePermissionsDTO), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(path)
                .post(requestBody)
                .addHeader("AUTH_TOKEN", tokenPermissoes)
                .build();
        return request;
    }

}
