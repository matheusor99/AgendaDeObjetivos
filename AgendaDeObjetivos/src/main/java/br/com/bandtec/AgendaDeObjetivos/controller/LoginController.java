package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credencias credencias) {
		if(credencias.getSenha().equals(credencias.getLogin())) {
			return ResponseEntity.ok("Login efetuado com sucesso");			
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("erro");
		}
	}
}
