package org.example.gateway.usecase.configuracoes.permissoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.gateway.config.JsonUtils;
import org.example.gateway.config.RotasPermissionadasAuthFilter;
import org.example.gateway.entities.RotasPermissionadasEntity;
import org.example.gateway.services.RotasPermissionadasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
public class ConfigurarPermissoesUseCase {

    private RotasPermissionadasAuthFilter rotasPermissionadasAuthFilter;
    private JsonUtils jsonUtils;
    private RotasPermissionadasService rotasPermissionadasService;

    public void executar(ConfigurarPermissoesInput entrada) {
        List<RotasPermissionadasAuthFilter.RoutePermission> rotas = new ArrayList<>();

        for (ConfigurarPermissoesInput.RoutePermission routePermission : entrada.getRoutePermissions()) {

            if (rotasPermissionadasAuthFilter.existePath(routePermission.getPath())) continue;

            rotas.add(RotasPermissionadasAuthFilter.RoutePermission.builder()
                    .applicationName(routePermission.getApplicationName())
                    .path(routePermission.getPath())
                    .authorities(routePermission.getAuthorities())
                    .methods(routePermission.getMethods())
                    .build());
        }

        rotasPermissionadasAuthFilter.addRoute(rotas);

        String nomeAplicacao = entrada.getRoutePermissions().get(0).getApplicationName();
        String jsonRotasPermissionadasAuthFilter = jsonUtils.toJson(rotasPermissionadasAuthFilter.getRoutePermissions().stream().filter(route -> route.getApplicationName().equals(nomeAplicacao)).collect(Collectors.toSet()));

        RotasPermissionadasEntity rotasPermissionadasEntity = rotasPermissionadasService.buscarPorNomeAplicacao(nomeAplicacao)
                .orElse(null);

        if (Objects.isNull(rotasPermissionadasEntity)) {
            rotasPermissionadasEntity = RotasPermissionadasEntity.builder()
                    .nomeAplicacao(nomeAplicacao)
                    .permissoes(jsonRotasPermissionadasAuthFilter)
                    .build();

            rotasPermissionadasService.criar(rotasPermissionadasEntity);
        } else {
            rotasPermissionadasEntity.setPermissoes(jsonRotasPermissionadasAuthFilter);
            rotasPermissionadasService.editar(rotasPermissionadasEntity);
        }

    }

}
