package br.com.mercadolivre.model;

public class Anuncio{

	private String codigo;
	private int estoque;
	private String titulo;
	private int quantidadeVendas;
	private double preco = 0; //estou cometendo uma heresia!!! sempre utilizar BigDecimal para propriedades que representem valores monetarios.

	public Anuncio() {

	}

	public Anuncio(String codigo, int estoque, String titulo, int quantidadeVendas) {
		this.codigo = codigo;
		this.estoque = estoque;
		this.titulo = titulo;
		this.quantidadeVendas = quantidadeVendas;
	}
	
	public Anuncio(String codigo, int estoque, String titulo, int quantidadeVendas, double preco) {
		this.codigo = codigo;
		this.estoque = estoque;
		this.titulo = titulo;
		this.quantidadeVendas = quantidadeVendas;
		this.preco = preco;
	}

	public Anuncio(String codigo, String titulo, int estoque) {
		this.codigo = codigo;
		this.estoque = estoque;
		this.titulo = titulo;
	}
	
	public Anuncio(String titulo, int estoque) {
		this.estoque = estoque;
		this.titulo = titulo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	@Override
	public String toString() {
		return "[" + "codigo: " + codigo + ", estoque: " + estoque + ", titulo: " + titulo
				+ ", vendas: " + quantidadeVendas + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Anuncio a = ((Anuncio) obj);
		return titulo.equals(a.titulo);
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
