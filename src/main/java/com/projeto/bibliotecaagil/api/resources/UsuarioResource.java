package com.projeto.bibliotecaagil.api.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> store(@RequestBody Usuario usuario) {
		Usuario novoUsuario = null;
		Map<String, String> response = new HashMap<String, String>();
		
		try {
			usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
			novoUsuario = usuarioRepository.save(usuario);
			novoUsuario.setPassword("");
			return new ResponseEntity<Usuario>(novoUsuario, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("error", "Usuário não pode ser criado");
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
}
