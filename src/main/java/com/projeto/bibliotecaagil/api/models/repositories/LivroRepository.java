package com.projeto.bibliotecaagil.api.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bibliotecaagil.api.models.entities.Livro;
import com.projeto.bibliotecaagil.api.models.enuns.StatusDoLivro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	List<Livro> findAllByStatus(StatusDoLivro status);
}
