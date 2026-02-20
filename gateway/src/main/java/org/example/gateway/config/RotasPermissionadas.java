package org.example.gateway.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
public class RotasPermissionadas {
    private List<RoutePermission> routePermissions;

    @Data
    @Builder
    public static class RoutePermission {
        private String applicationName;
        private String path;
        private List<String> methods;
        private List<String> authorities;

        public String getUrl() {
            return "/" + this.applicationName + this.path;
        }

    }

    public void addRoute(List<RoutePermission> routes) {
        routePermissions.addAll(routes);
    }

}
