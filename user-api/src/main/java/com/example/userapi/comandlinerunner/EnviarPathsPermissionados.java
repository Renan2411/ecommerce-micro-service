package com.example.userapi.comandlinerunner;

import com.example.userapi.usecases.integration.permissionamento.IPermissionamentoIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnviarPathsPermissionados implements CommandLineRunner {

    @Autowired
    private IPermissionamentoIntegration iPermissionamentoIntegration;

    @Override
    public void run(String... args) throws Exception {
        iPermissionamentoIntegration.enviarPathsPermissionados();
    }

}
