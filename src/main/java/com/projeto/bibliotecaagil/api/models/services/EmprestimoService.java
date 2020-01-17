package com.projeto.bibliotecaagil.api.models.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bibliotecaagil.api.models.dtos.EmprestimoRequestBodyDTO;
import com.projeto.bibliotecaagil.api.models.entities.Emprestimo;
import com.projeto.bibliotecaagil.api.models.entities.Livro;
import com.projeto.bibliotecaagil.api.models.enuns.Status;
import com.projeto.bibliotecaagil.api.models.repositories.EmprestimoRepository;
import com.projeto.bibliotecaagil.api.models.repositories.LivroRepository;

@Service
public class EmprestimoService {

	private LivroRepository livroRepository;
	private EmprestimoRepository emprestimoRepository;
	
	public EmprestimoService() {
	}
	
	@Autowired
	public EmprestimoService(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository) {
		this.livroRepository = livroRepository;
		this.emprestimoRepository = emprestimoRepository;
	}


	public Emprestimo store(EmprestimoRequestBodyDTO dadosDoEmprestimo) {
		Livro livroFromDB = buscarLivroNaBaseDeDados(dadosDoEmprestimo);
		livroFromDB.setStatus(Status.INDISPONIVEL);
		Emprestimo emprestimo = new Emprestimo(livroFromDB);
		return emprestimoRepository.save(emprestimo);
		
	}
	
	public Emprestimo update(EmprestimoRequestBodyDTO dadosDoEmprestimo, Long emprestimoId) {
		Emprestimo emprestimoFromDB = emprestimoRepository.findById(emprestimoId).orElse(null);
		emprestimoFromDB.getLivro().setStatus(Status.DISPONIVEL);
		emprestimoFromDB.setDataEntrega(LocalDate.now());
		return emprestimoRepository.save(emprestimoFromDB);
	}

	private Livro buscarLivroNaBaseDeDados(EmprestimoRequestBodyDTO dadosDoEmprestimo) {
		Livro livroFromDB = livroRepository.findById(dadosDoEmprestimo.getNumeroLivro())
				.orElse(null);
		return livroFromDB;
	}
}
