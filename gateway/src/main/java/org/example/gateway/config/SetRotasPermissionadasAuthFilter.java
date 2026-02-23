package org.example.gateway.config;

import org.example.gateway.entities.RotasPermissionadasEntity;
import org.example.gateway.services.RotasPermissionadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SetRotasPermissionadasAuthFilter implements CommandLineRunner {

    @Autowired
    private RotasPermissionadasAuthFilter rotasPermissionadasAuthFilter;

    @Autowired
    private RotasPermissionadasService rotasPermissionadasService;

    @Autowired
    private JsonUtils jsonUtils;

    @Override
    public void run(String... args) throws Exception {
        List<RotasPermissionadasEntity> rotasPermissionadasEntities = rotasPermissionadasService.buscarListagem();

        if (rotasPermissionadasEntities.isEmpty()) return;

        for (RotasPermissionadasEntity rotasPermissionadasEntity : rotasPermissionadasEntities) {
            List<RotasPermissionadasAuthFilter.RoutePermission> rotas = jsonUtils.fromJsonList(rotasPermissionadasEntity.getPermissoes(), RotasPermissionadasAuthFilter.RoutePermission.class);

            rotasPermissionadasAuthFilter.addRoute(rotas);
        }
    }
}
