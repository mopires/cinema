package br.com.cinema.model;


public class Ingresso {
	
	private Long id;
	private Long id_ingresso_usuario;
	private Long id_ingresso_filme;
	private float preco;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_ingresso_usuario() {
		return id_ingresso_usuario;
	}
	public void setId_ingresso_usuario(Long id_ingresso_usuario) {
		this.id_ingresso_usuario = id_ingresso_usuario;
	}
	public Long getId_ingresso_filme() {
		return id_ingresso_filme;
	}
	public void setId_ingresso_filme(Long id_ingresso_filme) {
		this.id_ingresso_filme = id_ingresso_filme;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	
}
