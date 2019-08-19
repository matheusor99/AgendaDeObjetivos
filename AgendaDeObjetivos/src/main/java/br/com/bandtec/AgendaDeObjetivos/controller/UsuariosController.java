package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {
	
	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(
			@PathVariable("nomeDoUsuario") String nome) {
		List<Usuario> usuariosPorNome = new ArrayList<>();
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome)) {
				usuariosPorNome.add(u); 
			}
		}
		if(usuariosPorNome.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		 return ResponseEntity.ok(usuariosPorNome);
	}
	
	private List<Usuario> obterTodosUsuarios() {
		return Arrays.asList(
				new Usuario("Rodrigo", 39),
				new Usuario("Rodrigo", 30),
				new Usuario("Michelle", 18)
				);
	}
}
