package org.example.gateway.usecase.configuracoes.permissoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.gateway.config.RotasPermissionadas;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
public class ConfigurarPermissoesUseCase {

    private RotasPermissionadas rotasPermissionadas;

    public void executar(ConfigurarPermissoesInput entrada) {
        List<RotasPermissionadas.RoutePermission> rotas = new ArrayList<>();
        for (ConfigurarPermissoesInput.RoutePermission routePermission : entrada.getRoutePermissions()) {

            rotas.add(RotasPermissionadas.RoutePermission.builder()
                    .applicationName(routePermission.getApplicationName())
                    .path(routePermission.getPath())
                    .authorities(routePermission.getAuthorities())
                    .methods(routePermission.getMethods())
                    .build());
        }

        rotasPermissionadas.addRoute(rotas);
    }

}
