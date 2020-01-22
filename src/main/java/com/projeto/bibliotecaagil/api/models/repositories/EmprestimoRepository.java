package com.projeto.bibliotecaagil.api.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bibliotecaagil.api.models.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	List<Emprestimo> findAllByUsuarioEmailAndDataEntregaIsNull(String email);
}
