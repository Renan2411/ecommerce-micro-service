package org.example.gateway.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RotasPermissionadasAuthFilterUtils {
    private List<RoutePermission> routePermissions = new ArrayList<>();

    public void adicionarRotas(List<RoutePermission> routes) {
        routePermissions.addAll(routes);
    }

    public RoutePermission buscarPorPath(String path) {
        return routePermissions.stream()
                .filter(route -> route.getPath().equals(path))
                .findFirst()
                .orElse(null);
    }

    public Integer buscarIndicePorPath(String path) {
        return routePermissions.indexOf(buscarPorPath(path));
    }

    public void editarRota(RoutePermission routePermission, Integer indice) {
        routePermissions.set(indice, routePermission);
    }

    public boolean ehRotaJaConfigurada(String path) {
        return this.routePermissions
                .stream()
                .anyMatch(route -> route.getPath().equals(path));
    }

    public Set<RoutePermission> buscarRotasCondiguradasPorNomeAplicacao(String nomeAplicacao) {
        return routePermissions
                .stream()
                .filter(route -> route.getApplicationName().equals(nomeAplicacao))
                .collect(java.util.stream.Collectors.toSet());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RoutePermission {
        private String applicationName;
        private String path;
        private List<String> methods;
        private List<String> authorities;
        private String url;

        public String getUrl() {
            return "/" + this.applicationName + this.path;
        }

    }

}
