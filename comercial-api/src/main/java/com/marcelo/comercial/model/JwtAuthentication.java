package com.marcelo.comercial.model;

public class JwtAuthentication {

	private String usuario;	
	private String password;
	
	public JwtAuthentication() {
		super();
	}

	public JwtAuthentication(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
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
	
}
