package br.com.mercadolivre.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Engenheiro extends Funcionario{

	private String projeto = "";
	
	public Engenheiro(String cpf, String nome, LocalDate dataNascimento, String logradouro, String complemento,
			int numero, String cep, String bairro) {
		
		
		super(cpf, nome, dataNascimento, logradouro, complemento, numero, cep, bairro);
	}
	
	
	@Override
	public BigDecimal getRemuneracao() {
		return super.getRemuneracao().add(getBonificacao());
	}

	@Override
	public BigDecimal getBonificacao() {
		return getSalario().multiply(BigDecimal.valueOf(0.05));
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public String toString() {
		return super.toString() + "     |     projeto: " + projeto;
	}

}
