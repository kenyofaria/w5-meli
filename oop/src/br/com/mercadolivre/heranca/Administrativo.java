package br.com.mercadolivre.heranca;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Administrativo extends Funcionario{

	public Administrativo(String cpf, String nome, LocalDate dataNascimento, String logradouro, String complemento,
			int numero, String cep, String bairro) {
		super(cpf, nome, dataNascimento, logradouro, complemento, numero, cep, bairro);
	}

	@Override
	public BigDecimal getBonificacao() {
		return new BigDecimal(0);
	}

}
