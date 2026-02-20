package com.example.userapi.entities.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ConfigurationProperties(prefix = "security")
public class RoutePermissionsDTO {

    private List<RoutePermission> routePermissions;

    @Data
    public static class RoutePermission {
        private String applicationName = "user-api";
        private String path;
        private List<String> methods = new ArrayList<>();
        private List<String> authorities = new ArrayList<>();
    }

}
