package br.com.best2bee.fornecedor.controller.dto;

public class TokenDto {

	private String token;
	private String string;

	public TokenDto(String token, String string) {
		this.token = token;
		this.string = string;
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public String getString() {
		return string;
	}

}
