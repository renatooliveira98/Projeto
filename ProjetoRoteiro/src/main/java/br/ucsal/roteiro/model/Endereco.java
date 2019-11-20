package br.ucsal.roteiro.model;

public class Endereco {

	private Integer id;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private Integer numero;
	
	public Endereco() {
		super();
	}

	public Endereco(Integer id, String cidade, String cep, String bairro, String rua, Integer numero) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}
