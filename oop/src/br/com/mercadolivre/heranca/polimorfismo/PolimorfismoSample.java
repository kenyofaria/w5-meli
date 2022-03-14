package br.com.mercadolivre.heranca.polimorfismo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import br.com.mercadolivre.heranca.Administrativo;
import br.com.mercadolivre.heranca.Engenheiro;
import br.com.mercadolivre.heranca.Funcionario;
import br.com.mercadolivre.heranca.Gerente;

public class PolimorfismoSample {

	public static void main(String[] args) {
		
		
		FolhaPagamento folha = new FolhaPagamento();
		
		
		Administrativo kenyo = new Administrativo("948.233.233-50", "kenyo", LocalDate.of(1980, Month.FEBRUARY, 25), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro do kenyo");
		kenyo.setSalario(new BigDecimal(1201));
		System.out.println(kenyo);
		System.out.println(kenyo.getSalario() + "     " + kenyo.getDescontos() + "     " + kenyo.getBonificacao());
		System.out.println(kenyo.getRemuneracao());
		
		folha.adiciona(kenyo);
		
		System.out.println("--------------------------------");
		Engenheiro mauri = new Engenheiro("777.233.233-50", "mauri", LocalDate.of(1981, Month.APRIL, 30), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro do mauri");
		mauri.setSalario(BigDecimal.valueOf(10000));
		System.out.println(mauri);
		System.out.println(mauri.getSalario() + "     " + mauri.getDescontos() + "     " +  mauri.getBonificacao());
		System.out.println(mauri.getRemuneracao());
		
		folha.adiciona(mauri);
		
		System.out.println("--------------------------------");
		Engenheiro joice = new Engenheiro("888.233.233-50", "joice", LocalDate.of(2008, Month.APRIL, 30), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro da joice");
		joice.setSalario(BigDecimal.valueOf(15000));
		joice.setProjeto("securitizacao");
		System.out.println(joice);
		System.out.println(joice.getSalario() + "     " + joice.getDescontos() + "     " +  joice.getBonificacao());
		System.out.println(joice.getRemuneracao());
		
		folha.adiciona(joice);
		
		
		System.out.println("--------------------------------");
		Gerente michele = new Gerente("333.233.233-50", "michele", LocalDate.of(2008, Month.APRIL, 30), "rua xyz", "q. 10 lt. 20", 0, "74000-000", "bairro da michele");
		michele.setSalario(BigDecimal.valueOf(30000));
		System.out.println(michele);
		System.out.println(michele.getSalario() + "     " + michele.getDescontos() + "     " +  michele.getBonificacao());
		System.out.println(michele.getRemuneracao());
		
		folha.adiciona(michele);
		
		
		System.out.println("\n\n--------------------------------------");
		System.out.println("            resumo da folha de pagamento");
		System.out.println("--------------------------------------");
		
		System.out.println(folha);
		
		
	}
	
}
