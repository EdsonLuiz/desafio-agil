package com.projeto.bibliotecaagil.api.models.dtos;

import java.io.Serializable;

public class EmprestimoRequestBodyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroLivro;
	
	private Long userId;
	
	public EmprestimoRequestBodyDTO() {
	}

	public Long getNumeroLivro() {
		return numeroLivro;
	}

	public void setNumeroLivro(Long numeroLivro) {
		this.numeroLivro = numeroLivro;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
