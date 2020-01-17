package com.projeto.bibliotecaagil.api.models.services;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.bibliotecaagil.api.models.entities.Usuario;
import com.projeto.bibliotecaagil.api.models.repositories.UsuarioRepository;

@Service
public class ApiUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuarioFromDB = usuarioRepository.findByEmail(email);
		Usuario usuario = usuarioFromDB
				.orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha incorretos"));
		
		return new User(usuario.getEmail(), usuario.getPassword(), new HashSet<>());
	}

}
