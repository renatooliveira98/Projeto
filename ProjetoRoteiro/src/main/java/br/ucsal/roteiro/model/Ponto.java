package br.ucsal.roteiro.model;

public class Ponto {

	private Integer id;
	private String descricao;
	private float x;
	private float y;
	
	public Ponto() {
		super();
	}
	
	public Ponto(Integer id, String descricao, float x, float y) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.x = x;
		this.y = y;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}

	
}
