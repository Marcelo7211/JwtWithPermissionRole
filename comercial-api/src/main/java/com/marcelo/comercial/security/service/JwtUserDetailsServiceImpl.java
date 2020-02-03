package com.marcelo.comercial.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcelo.comercial.model.User;
import com.marcelo.comercial.security.jwt.JwtUserFactory;
import com.marcelo.comercial.service.UserService;



@Service
public class JwtUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

    		User user = userService.findByUsuario(usuario).get();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", usuario));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}