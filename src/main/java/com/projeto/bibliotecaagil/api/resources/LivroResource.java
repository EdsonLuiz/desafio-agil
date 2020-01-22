package com.projeto.bibliotecaagil.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bibliotecaagil.api.models.entities.Livro;
import com.projeto.bibliotecaagil.api.models.enuns.StatusDoLivro;
import com.projeto.bibliotecaagil.api.models.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> index() {
		return livroRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Livro store(@RequestBody Livro livro ) {
		return livroRepository.save(livro);
	}
	
	@GetMapping("/disponivel")
	public List<Livro> findAllDisponivel() {
		return livroRepository.findAllByStatus(StatusDoLivro.DISPONIVEL);
	}
}
