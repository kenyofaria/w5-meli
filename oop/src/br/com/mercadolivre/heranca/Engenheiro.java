package br.com.mercadolivre.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Engenheiro extends Funcionario{

	public Engenheiro(String cpf, String nome, LocalDate dataNascimento, String logradouro, String complemento,
			int numero, String cep, String bairro) {
		
		
		super(cpf, nome, dataNascimento, logradouro, complemento, numero, cep, bairro);
	}
	
	public BigDecimal getBonificacao() {
		return getSalario().multiply(BigDecimal.valueOf(0.05));
	}
	
	@Override
	public BigDecimal getRemuneracao() {
		return super.getRemuneracao().add(getBonificacao());
	}

}
