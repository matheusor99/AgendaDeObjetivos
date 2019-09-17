package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.model.TodosUsuarios;
import br.com.bandtec.AgendaDeObjetivos.model.Usuario;

@RestController
public class LoginController{
	
	private TodosUsuarios usuarios;
	
	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.usuarios = todosUsuarios;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credencias) {
		if(credencias.getSenha().equals(credencias.getLogin())) {
			return ResponseEntity.ok("Login efetuado com sucesso");			
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("erro");
		}
	}
	
	@PostMapping("/login/login")
	public ResponseEntity<Usuario> validacaoLogin(@RequestBody Usuario usuario) {
		Usuario sucesso = usuarios.existe(usuario.getLogin(), usuario.getSenha());
		return ResponseEntity.ok(sucesso);
	}
	
	@PostMapping("cadastrar")
	public void cadastrar(@RequestBody Usuario usuario) {
		usuarios.save(usuario);
	}
}
