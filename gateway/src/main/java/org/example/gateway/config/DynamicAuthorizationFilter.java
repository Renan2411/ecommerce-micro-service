package org.example.gateway.config;

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
    private RotasPermissionadas rotasPermissionadas;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(rotasPermissionadas.toString());

        verificarAutenticacaoParaSetarPermissoes(httpServletRequest);
        verificarPermissoes(httpServletRequest);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void verificarAutenticacaoParaSetarPermissoes(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getRequestURI().equals(URL_SET_PERMISSIONS)) {
            String header = httpServletRequest.getHeader("AUTH_TOKEN");

            if (Objects.isNull(header) || !header.equals(tokenPermissions)) {
                throw new RuntimeException("Autenticação inválida!");
            }

        }
    }

    private void verificarPermissoes(HttpServletRequest httpServletRequest) {
        if (rotasPermissionadas.getRoutePermissions().isEmpty()) return;

        String path = httpServletRequest.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        for (RotasPermissionadas.RoutePermission route : rotasPermissionadas.getRoutePermissions()) {
            if (!antPathMatcher.match(route.getUrl(), path)) continue;

            String method = httpServletRequest.getMethod();

            if (!route.getMethods().contains(method)) continue;

            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            boolean possuiPermissao = authorities.stream().anyMatch(authoritie -> route.getAuthorities().contains(authoritie.toString()));

            if (!possuiPermissao) {
                throw new RuntimeException("Usuário não possui permissão.");
            }

        }

    }

}