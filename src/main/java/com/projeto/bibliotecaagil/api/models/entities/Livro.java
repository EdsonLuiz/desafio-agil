package com.projeto.bibliotecaagil.api.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.projeto.bibliotecaagil.api.models.enuns.Status;

@Entity
@Table(name = "livros")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	private String titulo;
	private String autor;

	@Column(name = "ano_publicado")
	private String anoPublicado;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Long getNumero() {
		return numero;
	}

	public Livro() {

	}

	public Livro(Long numero, String titulo, String autor, String anoPublicado, Status status) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicado = anoPublicado;
		this.status = status;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAnoPublicado() {
		return anoPublicado;
	}

	public void setAnoPublicado(String anoPublicado) {
		this.anoPublicado = anoPublicado;
	}

	@PrePersist
	public void defaultStatusOnCreate() {
		this.status = Status.DISPONIVEL;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
