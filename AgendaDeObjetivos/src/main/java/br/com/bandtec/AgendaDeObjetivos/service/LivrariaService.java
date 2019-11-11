package br.com.bandtec.AgendaDeObjetivos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bandtec.AgendaDeObjetivos.model.Livro;
import br.com.bandtec.AgendaDeObjetivos.model.Opiniao;

@Service
public class LivrariaService {
	
	private RestTemplate restTemplate;
	private String url = "http://localhost:8081/livros"; 
	
	public LivrariaService() {
		this.restTemplate = new RestTemplate();
	}
	
	public List<Livro> buscarPorTema(String tema) {
		String urlBusca = url + "/tema/" + tema;
		
		ResponseEntity<List> resposta = restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}

	public String adicionarOpiniao(Opiniao opiniao) {
		String urlCadastro = url+"/opiniao";
		ResponseEntity<String> resposta = restTemplate.postForEntity(urlCadastro, opiniao, String.class);
		return resposta.getBody();
	}
}
