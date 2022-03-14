package br.com.mercadolivre.heranca.reuso;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import br.com.mercadolivre.heranca.Administrativo;
import br.com.mercadolivre.heranca.Engenheiro;
import br.com.mercadolivre.heranca.Funcionario;

public class ReusoSample {

	
	
	public static void main(String[] args) {
		
		Administrativo funcionario = new Administrativo("948.233.233-50", "kenyo", LocalDate.of(1980, Month.FEBRUARY, 25), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro do kenyo");
		funcionario.setSalario(new BigDecimal(1201));
		System.out.println(funcionario);
		System.out.println(funcionario.getSalario() + "     " + funcionario.getDescontos());
		System.out.println(funcionario.getRemuneracao());
		
		
		System.out.println("--------------------------------");
		Engenheiro mauri = new Engenheiro("777.233.233-50", "mauri", LocalDate.of(1981, Month.APRIL, 30), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro do mauri");
		mauri.setSalario(BigDecimal.valueOf(10000));
		System.out.println(mauri);
		System.out.println(mauri.getSalario() + "  " + mauri.getBonificacao());
		System.out.println(mauri.getRemuneracao());
		
		
		System.out.println("--------------------------------");
		Engenheiro joice = new Engenheiro("888.233.233-50", "joice", LocalDate.of(2008, Month.APRIL, 30), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro da joice");
		joice.setSalario(BigDecimal.valueOf(15000));
		System.out.println(joice);
		System.out.println(joice.getSalario() + "  " + joice.getBonificacao());
		System.out.println(joice.getRemuneracao());
		
	
		System.out.println("-------------------- total de funcionarios  -----------------------");
		System.out.println("qtde de funcionarios: " + Funcionario.getQtdeFuncionarios());
	}
}
