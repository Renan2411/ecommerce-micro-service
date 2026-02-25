package org.example.gateway.setup;

import org.example.gateway.utils.RotasPermissionadasAuthFilterUtils;
import org.example.gateway.entities.RotasPermissionadasEntity;
import org.example.gateway.services.RotasPermissionadasService;
import org.example.gateway.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RotasPermissionadasAuthFilterSetup implements CommandLineRunner {

    @Autowired
    private RotasPermissionadasAuthFilterUtils rotasPermissionadasAuthFilterUtils;

    @Autowired
    private RotasPermissionadasService rotasPermissionadasService;

    @Autowired
    private JsonUtils jsonUtils;

    @Override
    public void run(String... args) throws Exception {
        List<RotasPermissionadasEntity> rotasPermissionadasEntities = rotasPermissionadasService.buscarListagem();

        if (rotasPermissionadasEntities.isEmpty()) return;

        for (RotasPermissionadasEntity rotasPermissionadasEntity : rotasPermissionadasEntities) {
            List<RotasPermissionadasAuthFilterUtils.RoutePermission> rotas = jsonUtils.fromJsonList(rotasPermissionadasEntity.getPermissoes(), RotasPermissionadasAuthFilterUtils.RoutePermission.class);

            rotasPermissionadasAuthFilterUtils.adicionarRotas(rotas);
        }
    }
}
