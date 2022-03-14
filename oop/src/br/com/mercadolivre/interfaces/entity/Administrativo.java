package br.com.mercadolivre.interfaces.entity;

import java.math.BigDecimal;

import br.com.mercadolivre.interfaces.UsuarioAutenticavel;

public class Administrativo implements UsuarioAutenticavel{

	
	private DadosPessoais dadosPessoais;
	private Endereco endereco;
	private DadosTrabalhistas dadosTrabalhistas;
	

	public Administrativo() {
		// TODO Auto-generated constructor stub
	}
	
	public Administrativo(DadosPessoais dadosPessoais, Endereco endereco, DadosTrabalhistas dadosTrabalhistas) {
		super();
		this.dadosPessoais = dadosPessoais;
		this.endereco = endereco;
		this.dadosTrabalhistas = dadosTrabalhistas;
		defineBonificacao();
	}
	
	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public BigDecimal getBonificacao() {
		defineBonificacao();
		return dadosTrabalhistas.getBonificacao();
	}

	private void defineBonificacao() {
		dadosTrabalhistas.setBonificacao(dadosTrabalhistas.getSalario().multiply(BigDecimal.valueOf(0)));
	}
	
	public BigDecimal getRemuneracao() {
		return dadosTrabalhistas.getSalario().subtract(dadosTrabalhistas.getDescontos()).add(getBonificacao());
	}

	@Override
	public boolean autentica(String loin, String senha) {
		// TODO Auto-generated method stub
		// autenticacao buscando os dados do usuario no postgres/mysql
		return false;
	}
	
	@Override
	public String toString() {
		return dadosPessoais.toString() + "\n " + dadosTrabalhistas.toString();
	}

}
