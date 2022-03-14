package br.com.mercadolivre.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import br.com.mercadolivre.interfaces.entity.Administrativo;
import br.com.mercadolivre.interfaces.entity.DadosPessoais;
import br.com.mercadolivre.interfaces.entity.DadosTrabalhistas;
import br.com.mercadolivre.interfaces.entity.Endereco;
import br.com.mercadolivre.interfaces.entity.Engenheiro;
import br.com.mercadolivre.interfaces.entity.Gerente;

public class PrintFuncionarios {

	public static void main(String[] args) {
		
		Engenheiro joice = new Engenheiro(
					new DadosPessoais("398.343.123-23", "joice", LocalDate.of(1995, Month.AUGUST, 10)), 
					new Endereco("4353453", "principal rua do morumbi", 0, "q 5 l 14", "morumbi"), 
					new DadosTrabalhistas(BigDecimal.valueOf(30000))
				);
		
		Administrativo kenyo = new Administrativo(
					new DadosPessoais("444.343.123-23", "kenyo", LocalDate.of(1995, Month.AUGUST, 10)),
					new Endereco("4564565", "principal rua do morumbi", 0, "q 1 l 17", "morumbi"), 
					new DadosTrabalhistas(BigDecimal.valueOf(2000))
				);
		
		
		Gerente michele = new Gerente(
					new DadosPessoais("555.343.123-23", "michele", LocalDate.of(1995, Month.AUGUST, 10)),
					new Endereco("4564565", "principal rua do morumbi", 0, "q 19 l 1", "morumbi"), 
					new DadosTrabalhistas(BigDecimal.valueOf(45000))
				);
		
		
		System.out.println(joice);
		System.out.println(kenyo);
		System.out.println(michele);
	}
}
