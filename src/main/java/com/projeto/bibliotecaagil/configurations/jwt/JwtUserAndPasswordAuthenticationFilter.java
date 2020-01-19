package com.projeto.bibliotecaagil.configurations.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUserAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	
	private final AuthenticationManager authenticationManager;
	
	
	@Autowired
	public JwtUserAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException {
		
		
		try {
			UserAndPasswordRequestDTO authenticationRequest = new ObjectMapper()
					.readValue(request.getInputStream(), UserAndPasswordRequestDTO.class);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), 
					authenticationRequest.getPassword()
			);
			
			Authentication authenticate = authenticationManager.authenticate(authentication);
			return authenticate;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String key = "biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_biblioteca_agil_";
		String token = Jwts.builder()
			.setSubject(authResult.getName())
			.claim("username", authResult.getName())
			.setIssuedAt(new Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
			.signWith(Keys.hmacShaKeyFor(key.getBytes()))
			.compact();
		
		response.addHeader("Authorization","Bearer "+ token);
//		super.successfulAuthentication(request, response, chain, authResult);
	}

}
