package br.com.mercadolivre.interfaces.entity;

import java.math.BigDecimal;

public class DadosTrabalhistas {

	private BigDecimal salario;
	private BigDecimal descontos;
	private BigDecimal bonificacao;
	
	
	public DadosTrabalhistas(BigDecimal salario) {
		super();
		this.salario = salario;
		//this.descontos = descontos;
		//this.bonificacao = bonificacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public BigDecimal getBonificacao() {
		return bonificacao;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public void setBonificacao(BigDecimal bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "salario: " + salario 
				+ "  descontos: " + descontos 
				+ "   " + " bonificacao: " + bonificacao;
	}
}
