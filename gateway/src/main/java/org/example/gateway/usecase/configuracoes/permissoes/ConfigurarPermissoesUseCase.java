package org.example.gateway.usecase.configuracoes.permissoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.example.gateway.utils.JsonUtils;
import org.example.gateway.utils.RotasPermissionadasAuthFilterUtils;
import org.example.gateway.entities.RotasPermissionadasEntity;
import org.example.gateway.services.RotasPermissionadasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
public class ConfigurarPermissoesUseCase {

    private RotasPermissionadasAuthFilterUtils rotasPermissionadasAuthFilterUtils;
    private JsonUtils jsonUtils;
    private RotasPermissionadasService rotasPermissionadasService;

    public void executar(ConfigurarPermissoesInput entrada) {
        configurarRotas(entrada);
        persistirRotasConfiguradas(entrada);
    }

    private void configurarRotas(ConfigurarPermissoesInput entrada) {
        List<RotasPermissionadasAuthFilterUtils.RoutePermission> rotasConfiguradas = new ArrayList<>();

        for (ConfigurarPermissoesInput.RoutePermission routePermission : entrada.getRoutePermissions()) {
            RotasPermissionadasAuthFilterUtils.RoutePermission rotaExistente = rotasPermissionadasAuthFilterUtils.buscarPorPath(routePermission.getPath());

            if (Objects.nonNull(rotaExistente)) {
                reconfigurarRotaPermissionada(routePermission, rotaExistente);
            } else {
                rotasConfiguradas.add(RotasPermissionadasAuthFilterUtils.RoutePermission.builder()
                        .applicationName(routePermission.getApplicationName())
                        .path(routePermission.getPath())
                        .authorities(routePermission.getAuthorities())
                        .methods(routePermission.getMethods())
                        .build());
            }
        }

        if (!rotasConfiguradas.isEmpty()) rotasPermissionadasAuthFilterUtils.adicionarRotas(rotasConfiguradas);
    }

    private void reconfigurarRotaPermissionada(ConfigurarPermissoesInput.RoutePermission routePermission, RotasPermissionadasAuthFilterUtils.RoutePermission rotaExistente) {
        Integer indice = rotasPermissionadasAuthFilterUtils.buscarIndicePorPath(routePermission.getPath());
        rotaExistente.setAuthorities(routePermission.getAuthorities());
        rotaExistente.setPath(routePermission.getPath());
        rotaExistente.setMethods(routePermission.getMethods());
        rotaExistente.setApplicationName(rotaExistente.getApplicationName());

        rotasPermissionadasAuthFilterUtils.editarRota(rotaExistente, indice);
    }

    private void persistirRotasConfiguradas(ConfigurarPermissoesInput entrada) {
        String nomeAplicacao = entrada.getRoutePermissions().get(0).getApplicationName();
        Set<RotasPermissionadasAuthFilterUtils.RoutePermission> rotasConfiguradas = rotasPermissionadasAuthFilterUtils.buscarRotasCondiguradasPorNomeAplicacao(nomeAplicacao);
        String jsonRotasConfiguradasAuthFilter = jsonUtils.toJson(rotasConfiguradas);

        RotasPermissionadasEntity rotasPermissionadasEntity = buscarRotasConfiguradasPersistidas(nomeAplicacao);

        if (Objects.isNull(rotasPermissionadasEntity)) {
            criarRotasPermissionadasEntity(nomeAplicacao, jsonRotasConfiguradasAuthFilter);
        } else {
            editarRotasPermissionadasEntity(rotasPermissionadasEntity, jsonRotasConfiguradasAuthFilter);
        }
    }

    private RotasPermissionadasEntity buscarRotasConfiguradasPersistidas(String nomeAplicacao) {
        return rotasPermissionadasService.buscarPorNomeAplicacao(nomeAplicacao)
                .orElse(null);
    }

    private void criarRotasPermissionadasEntity(String nomeAplicacao, String jsonRotasConfiguradasAuthFilter) {
        RotasPermissionadasEntity rotasPermissionadasEntity;
        rotasPermissionadasEntity = RotasPermissionadasEntity.builder()
                .nomeAplicacao(nomeAplicacao)
                .permissoes(jsonRotasConfiguradasAuthFilter)
                .build();

        rotasPermissionadasService.criar(rotasPermissionadasEntity);
    }

    private void editarRotasPermissionadasEntity(RotasPermissionadasEntity rotasPermissionadasEntity, String jsonRotasConfiguradasAuthFilter) {
        rotasPermissionadasEntity.setPermissoes(jsonRotasConfiguradasAuthFilter);
        rotasPermissionadasService.editar(rotasPermissionadasEntity);
    }

}
