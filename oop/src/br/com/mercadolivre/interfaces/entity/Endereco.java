package br.com.mercadolivre.interfaces.entity;

public class Endereco {

	private String cep;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(String cep, String logradouro, int numero, String complemento, String bairro) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}
	
	
}
