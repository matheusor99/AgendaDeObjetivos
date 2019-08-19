package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	
	private LoginController controller;
	
	@Before
	public void setUp() {
		controller = new LoginController();
	}
	
	@Test
	public void LoginComSucesso() {

		LoginController controller = new LoginController();

		ResponseEntity<String> resposta = controller.validarLogin(new Credencias("igual", "igual"));

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Login efetuado com sucesso", resposta.getBody());
	}

	@Test
	public void LoginComFalha() {
		LoginController controller = new LoginController();
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credencias("login", "senha"));
		
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("erro", resposta.getBody());		
	}

}
