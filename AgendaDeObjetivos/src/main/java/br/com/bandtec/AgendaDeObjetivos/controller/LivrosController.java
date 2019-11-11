package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.Livro;
import br.com.bandtec.AgendaDeObjetivos.model.Opiniao;
import br.com.bandtec.AgendaDeObjetivos.service.LivrariaService;

@RestController
public class LivrosController {
	
	private LivrariaService livraria;
	
	@Autowired
	public LivrosController(LivrariaService livraria) {
		this.livraria = livraria;
	}
	
	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> buscarPorTema(@PathVariable("tema") String tema) {
		List<Livro> livros = livraria.buscarPorTema(tema);
		
		if(livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} 
		
		return ResponseEntity.ok(livros);
	}
	
	@PostMapping("/livros/opiniao")
	public ResponseEntity<String> cadastrarOpiniao(@RequestBody Opiniao opiniao) {
		String resposta = livraria.adicionarOpiniao(opiniao);
		return ResponseEntity.ok(resposta);
	}
}
