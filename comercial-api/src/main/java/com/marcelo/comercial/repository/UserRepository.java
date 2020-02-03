package com.marcelo.comercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.comercial.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsuario(String usuario);
}
