package com.projeto.bibliotecaagil.api.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bibliotecaagil.api.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
