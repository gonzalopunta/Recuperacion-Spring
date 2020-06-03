package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.JWT.JWTUtilToken;
import com.example.JWT.JwtRequest;
import com.example.JWT.JwtResponse;
import com.example.entity.Usuario;
import com.example.services.UsuarioService;

@RestController
@CrossOrigin
public class JWTAuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTUtilToken jwtTokenUtil;
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final Optional<Usuario> usuario = usuarioService.findByNombreUsuario(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(usuario.get());
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}