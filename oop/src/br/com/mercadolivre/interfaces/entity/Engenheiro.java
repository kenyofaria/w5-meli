package br.com.mercadolivre.interfaces.entity;

import java.math.BigDecimal;

public class Engenheiro{

	private String projeto = "";
	private DadosPessoais dadosPessoais;
	private Endereco endereco;
	private DadosTrabalhistas dadosTrabalhistas;
	
	
	public Engenheiro(DadosPessoais dadosPessoais, Endereco endereco, DadosTrabalhistas dadosTrabalhistas) {
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
		dadosTrabalhistas.setBonificacao(dadosTrabalhistas.getSalario().multiply(BigDecimal.valueOf(0.05)));
	}
	
	public BigDecimal getRemuneracao() {
		return dadosTrabalhistas.getSalario().subtract(dadosTrabalhistas.getDescontos()).add(getBonificacao());
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public String toString() {
		String tmp = dadosPessoais.toString()  +  "     |     projeto: " + projeto;
		return tmp + "\n" + dadosTrabalhistas.toString();
	}

}
