package br.ucsal.roteiro.model;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String nomeSocial;

	private String login;
	private String email;
	private String cpf;
	private String senha;
	private Endereco endereco;
	private Papel papel;
	
	public Usuario() {
		super();
	}


	public Usuario(Integer id, String nome, String nomeSocial, String login, String email, String cpf, String senha,
			Endereco endereco, Papel papel) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.login = login;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.papel = papel;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
	
}
