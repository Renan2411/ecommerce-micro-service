package org.example.gateway.usecase.configuracoes.permissoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurarPermissoesInput {

    private List<RoutePermission> routePermissions;

    @Data
    public static class RoutePermission {
        private String applicationName;
        private String path;
        private List<String> methods = new ArrayList<>();
        private List<String> authorities = new ArrayList<>();
    }

}
