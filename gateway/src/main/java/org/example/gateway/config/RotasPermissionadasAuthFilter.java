package org.example.gateway.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RotasPermissionadasAuthFilter {
    private List<RoutePermission> routePermissions = new ArrayList<>();

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

    public void addRoute(List<RoutePermission> routes) {
        routePermissions.addAll(routes);
    }

    public boolean existePath(String path) {
        return this.routePermissions
                .stream()
                .anyMatch(route -> route.getPath().equals(path));
    }

}
