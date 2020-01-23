package com.projeto.bibliotecaagil.api.models.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projeto.bibliotecaagil.api.models.entities.Emprestimo;
import com.projeto.bibliotecaagil.api.models.entities.Livro;
import com.projeto.bibliotecaagil.api.models.entities.Usuario;
import com.projeto.bibliotecaagil.api.models.enuns.StatusDoLivro;
import com.projeto.bibliotecaagil.api.models.repositories.EmprestimoRepository;
import com.projeto.bibliotecaagil.api.models.repositories.LivroRepository;
import com.projeto.bibliotecaagil.api.models.repositories.UsuarioRepository;

@Service
public class EmprestimoService {

	private LivroRepository livroRepository;
	private EmprestimoRepository emprestimoRepository;
	private UsuarioRepository usuarioRepository;
	private Authentication authentication;
	
	public EmprestimoService() {
	}
	
	@Autowired
	public EmprestimoService(LivroRepository livroRepository, 
							EmprestimoRepository emprestimoRepository,
							UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.livroRepository = livroRepository;
		this.emprestimoRepository = emprestimoRepository;
	}
	


	public List<Emprestimo> index() {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		return emprestimoRepository.findAllByUsuarioEmailAndDataEntregaIsNull(authentication.getName());
	}

	public Emprestimo store(Long numeroLivro) {
		Livro livroFromDB = livroRepository.findById(numeroLivro).orElse(null);
		authentication = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioRepository.findByEmail(authentication.getName()).orElse(null);
		livroFromDB.setStatus(StatusDoLivro.INDISPONIVEL);
		Emprestimo emprestimo = new Emprestimo(livroFromDB, usuario);
		return emprestimoRepository.save(emprestimo);
		
	}
	
	public Emprestimo update(Long emprestimoId) {
		Emprestimo emprestimoFromDB = emprestimoRepository.findById(emprestimoId).orElse(null);
		emprestimoFromDB.getLivro().setStatus(StatusDoLivro.DISPONIVEL);
		emprestimoFromDB.setDataEntrega(LocalDate.now());
		return emprestimoRepository.save(emprestimoFromDB);
	}

}
