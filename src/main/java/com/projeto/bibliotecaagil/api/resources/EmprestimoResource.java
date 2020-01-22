package com.projeto.bibliotecaagil.api.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bibliotecaagil.api.models.entities.Emprestimo;
import com.projeto.bibliotecaagil.api.models.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping
	public List<Emprestimo> index() {
		return emprestimoService.index();
	}
	
	@PostMapping
	public Emprestimo store(@RequestBody Map<String, Long> requestBody) {
		return emprestimoService.store(requestBody.get("numeroLivro"));
	}
	
	@PutMapping("/{emprestimoId}")
	public Emprestimo update(@PathVariable Long emprestimoId) {
		return emprestimoService.update(emprestimoId);
	}
}
