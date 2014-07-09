package org.eng2.model;

public class Item {
	
	private int id;
	private String titulo;
	private String descricao;
	private float preco;
	private String imagem;
	private int cardapio_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getCardapio_id() {
		return cardapio_id;
	}
	public void setCardapio_id(int cardapio_id) {
		this.cardapio_id = cardapio_id;
	}
	
	
}
