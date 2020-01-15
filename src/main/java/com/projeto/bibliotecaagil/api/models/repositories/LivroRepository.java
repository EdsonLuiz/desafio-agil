package com.projeto.bibliotecaagil.api.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projeto.bibliotecaagil.api.models.entities.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
