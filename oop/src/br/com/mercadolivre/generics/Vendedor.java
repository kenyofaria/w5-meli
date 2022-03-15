package br.com.mercadolivre.generics;

public class Vendedor {

	private String codigo;
	private String cpf;
	private String nome;
	public Vendedor(String codigo, String cpf, String nome) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return codigo.concat(";").concat(cpf).concat(";").concat(nome);
	}
}
