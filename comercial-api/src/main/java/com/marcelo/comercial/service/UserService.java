package com.marcelo.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.marcelo.comercial.model.User;

@Component
public interface UserService {

    Optional<User> findByUsuario(String usuario);
	
	User createOrUpdate(User user);
	
	User findById(Long id);
	
	List<User> findAll();
	
	void delete(Long id);    
}
