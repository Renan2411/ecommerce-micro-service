package com.example.authapi.config.auth;

import com.example.authapi.entities.UserEntity;
import com.example.authapi.services.integration.usuario.UsuarioIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private UsuarioIntegrationService usuarioIntegrationService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity usuario = usuarioIntegrationService.buscarPorCpf(login).getBody();

        if (Objects.isNull(usuario)) {
            logger.warning("Email Not found = " + login);

//            throw new IllegalArgumentException("Email not found");
            throw new UsernameNotFoundException("Email not found");
        }

        logger.info("Email Found = " + usuario.getUsername());
        return usuario;

    }

}
