package com.example.authapi.config.auth;

import com.example.authapi.entities.RoleEntity;
import com.example.authapi.entities.UserEntity;
import com.example.authapi.services.integration.usuario.IUsuarioIntegrationService;
import com.example.authapi.services.integration.usuario.responses.BuscarUsuarioPorCpfResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private IUsuarioIntegrationService IUsuarioIntegrationService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        BuscarUsuarioPorCpfResponse usuarioPorCpfResponse = IUsuarioIntegrationService.buscarPorCpf(login);

        UserEntity usuario = converterUsuario(usuarioPorCpfResponse);

        if (Objects.isNull(usuario)) {
            logger.warning("Email Not found = " + login);

            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("Email Found = " + usuario.getUsername());
        return usuario;

    }

    private UserEntity converterUsuario(BuscarUsuarioPorCpfResponse usuarioPorCpfResponse) {
        return UserEntity.builder()
                .id(usuarioPorCpfResponse.getId())
                .name(usuarioPorCpfResponse.getName())
                .cpf(usuarioPorCpfResponse.getCpf())
                .password(usuarioPorCpfResponse.getPassword())
                .roles(monterRoles(usuarioPorCpfResponse))
                .build();
    }

    private Set<RoleEntity> monterRoles(BuscarUsuarioPorCpfResponse usuarioPorCpfResponse) {
        return usuarioPorCpfResponse.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .id(role.getId())
                        .nome(role.getNome())
                        .descricao(role.getDescricao())
                        .build())
                .collect(Collectors.toSet());
    }

}
