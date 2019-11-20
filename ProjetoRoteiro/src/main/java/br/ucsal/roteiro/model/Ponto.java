package br.ucsal.roteiro.model;

public class Ponto {

	private Integer id;
	private String descricao;
	private long x;
	private long y;
	
	public Ponto() {
		super();
	}
	
	public Ponto(Integer id, String descricao, long x, long y) {
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
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}

	
}
