package br.com.bandtec.AgendaDeObjetivos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
//	private String nome;
//	
//	private Integer idade;

//	public String getNome() {
//		return nome;
//	}
//	public Usuario(String login, String senha) {
//		super();
//		this.login = login;
//		this.senha = senha;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public Integer getIdade() {
//		return idade;
//	}

//	public void setIdade(Integer idade) {
//		this.idade = idade;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
