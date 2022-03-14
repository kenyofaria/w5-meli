package br.com.mercadolivre.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Funcionario {

	private static int qtdeFuncionarios = 0;
	
	private static final BigDecimal BASECOMPARACAO = BigDecimal.valueOf(1200);
	
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	private String logradouro;
	private String complemento;
	private int numero;
	private String cep;
	private String bairro;
	private BigDecimal salario;
	
	public Funcionario(String cpf, String nome, LocalDate dataNascimento, String logradouro, String complemento,
			int numero, String cep, String bairro) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		qtdeFuncionarios+=1;
	}
	
	public Funcionario(String cpf, String nome, LocalDate dataNascimento, String logradouro, String complemento,
			int numero, String cep, String bairro, BigDecimal salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.salario = salario;
		qtdeFuncionarios+=1;
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

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public int getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public BigDecimal getDescontos() {
		if(salario.compareTo(BASECOMPARACAO) <= 0) {
			return new BigDecimal(0);
		}
		return salario.multiply(BigDecimal.valueOf(0.02));
	}
	
	public BigDecimal getRemuneracao() {
		return salario.subtract(getDescontos());
	}
	
	public static int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}
	public abstract BigDecimal getBonificacao();
	
	@Override
	public String toString() {
		return cpf + ", " + nome;
	}
	
}
