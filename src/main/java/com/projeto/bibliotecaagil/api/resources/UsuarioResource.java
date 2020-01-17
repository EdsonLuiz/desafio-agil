package com.projeto.bibliotecaagil.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bibliotecaagil.api.models.entities.Usuario;
import com.projeto.bibliotecaagil.api.models.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public Usuario store(@RequestBody Usuario usuario) {
		usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}
}
