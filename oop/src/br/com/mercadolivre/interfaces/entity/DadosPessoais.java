package br.com.mercadolivre.interfaces.entity;

import java.time.LocalDate;

public class DadosPessoais {
	
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	
	public DadosPessoais() {
		// TODO Auto-generated constructor stub
	}

	public DadosPessoais(String cpf, String nome, LocalDate dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cpf + "   " + nome;
	}
	
}
