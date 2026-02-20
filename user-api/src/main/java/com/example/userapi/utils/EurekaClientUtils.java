package com.example.userapi.utils;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EurekaClientUtils {

    private EurekaClient eurekaClient;

    public String baseUrlApplication(String nomeAplicacao) {
        try {
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(nomeAplicacao, false);
            return instanceInfo.getHomePageUrl();
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format("Erro ao buscar url base da aplicação : %s. Erro: [%s]", nomeAplicacao, e.getMessage()));
        }
    }

}
