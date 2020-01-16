package com.projeto.bibliotecaagil.api.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bibliotecaagil.api.models.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
