package br.com.mercadolivre.generics;

public class Anuncio {

	private String codigo;
	private String titulo;
	private double preco;
	
	public Anuncio(String codigo, String titulo, double preco) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return codigo.concat(";").concat(titulo).concat(";").concat(String.valueOf(preco));
	}
	
}
