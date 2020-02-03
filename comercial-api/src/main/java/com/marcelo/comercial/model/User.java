package com.marcelo.comercial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.marcelo.comercial.enums.ProfileEnum;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Usuario deve ser preenchido")
	@Size(min = 6, max = 20, message = "O Usuário deve ter no minimo 6 e no maximo 20 caracteres")
	private String usuario;
	
	@NotEmpty(message = "Senha deve ser preenchida")
	@Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
	private String password;
	
	private ProfileEnum profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}			
	
}
