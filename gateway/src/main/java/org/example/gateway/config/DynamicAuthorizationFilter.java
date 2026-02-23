package org.example.gateway.config;

import org.apache.http.HttpStatus;
import org.example.gateway.entities.dto.ApiErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

@Component
public class DynamicAuthorizationFilter extends OncePerRequestFilter {

    private final String URL_SET_PERMISSIONS = "/configuracao/permissoes";
    private final String HEADER_SET_PERMISSIONS = "AUTH_TOKEN";

    @Value("${token-permissions}")
    private String tokenPermissions;

    @Autowired
    private RotasPermissionadasAuthFilter rotasPermissionadasAuthFilter;

    @Autowired
    private JsonUtils jsonUtils;

    private String mensagemErroAoAcessarRota;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(rotasPermissionadasAuthFilter.toString());

        if (!usuarioPossuiTokenValidoParaConfiguracoesDePermissoesDeRotas(httpServletRequest, httpServletResponse)
                || !usuarioPossuiPermissaoParaAcessoAhRota(httpServletRequest)) {
            montarResponseError(httpServletResponse);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean usuarioPossuiTokenValidoParaConfiguracoesDePermissoesDeRotas(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        if (httpServletRequest.getRequestURI().equals(URL_SET_PERMISSIONS)) {
            String header = httpServletRequest.getHeader("AUTH_TOKEN");

            if (Objects.isNull(header) || !header.equals(tokenPermissions)) {
                this.mensagemErroAoAcessarRota = "Token de autenticação inválido.";
                return false;
            }
        }

        return true;
    }

    private boolean usuarioPossuiPermissaoParaAcessoAhRota(HttpServletRequest httpServletRequest) {
        if (Objects.isNull(rotasPermissionadasAuthFilter) || rotasPermissionadasAuthFilter.getRoutePermissions().isEmpty()) return true;

        boolean possuiPermisao = true;
        String path = httpServletRequest.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        for (RotasPermissionadasAuthFilter.RoutePermission route : rotasPermissionadasAuthFilter.getRoutePermissions()) {
            if (!antPathMatcher.match(route.getUrl(), path)) continue;

            String method = httpServletRequest.getMethod();

            if (!route.getMethods().contains(method)) continue;

            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            boolean possuiPermissaoNaRotaAtual = authorities.stream().anyMatch(authoritie -> route.getAuthorities().contains(authoritie.toString()));

            if (!possuiPermissaoNaRotaAtual) {
                mensagemErroAoAcessarRota = "Usuário não possuí permissão para acessar a rota.";
                possuiPermisao = false;
            }
        }

        return possuiPermisao;
    }

    private void montarResponseError(HttpServletResponse httpServletResponse) throws IOException {
        ApiErrorDTO apiErrorDTO = ApiErrorDTO.builder()
                .status(HttpStatus.SC_FORBIDDEN)
                .mensagem(mensagemErroAoAcessarRota)
                .build();

        httpServletResponse.setStatus(HttpStatus.SC_FORBIDDEN);
        httpServletResponse.setContentType("applications/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(jsonUtils.toJson(apiErrorDTO));
    }


}