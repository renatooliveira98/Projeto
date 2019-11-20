package br.ucsal.roteiro.model;

public class Curso {

	private Integer id;
	private Instituicao instituicao;
	private String nome;
	private Integer duracao; //em semestres
	
	public Curso() {
		super();
	}
	
	public Curso(Integer id, Instituicao instituicao, String nome, Integer duracao) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.nome = nome;
		this.duracao = duracao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
}
