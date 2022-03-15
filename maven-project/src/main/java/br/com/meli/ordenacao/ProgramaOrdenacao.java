package br.com.meli.ordenacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProgramaOrdenacao {

	
	
	public static void main(String[] args) {
		
		
		//sample1();
		
		List<Anuncio> anuncios = Arrays.asList(
				new Anuncio("ps5", LocalDate.of(2022, Month.MARCH, 01), new BigDecimal(5000)), 
				new Anuncio("iphone 13", LocalDate.of(2022, Month.MARCH, 9), new BigDecimal(15000)),  
				new Anuncio("fiat mobi", LocalDate.of(2022, Month.MARCH, 3), new BigDecimal(85000)),  
				new Anuncio("renault kwid", LocalDate.of(2022, Month.MARCH, 2), new BigDecimal(95000)) 
				);
		
		anuncios.forEach(treco -> System.out.println(treco));
		
		System.out.println("------------------------------------");
		Collections.sort(anuncios);
		anuncios.forEach(treco -> System.out.println(treco));
		
		System.out.println("------------------------------------");
		anuncios.sort((a,b) -> a.getData().compareTo(b.getData()));
		//Collections.sort(anuncios, Comparator.comparing(Anuncio::getData));
	
		anuncios.forEach(treco -> System.out.println(treco));
		
		
	}

	private static void sample1() {
		List<String> nomes  = new LinkedList<String>();
		nomes.add("Luiz");
		nomes.add("mariana");
		nomes.add("helena");
		nomes.add("bruno");
		nomes.add("Kenyo");
		
		Collections.sort(nomes);
		
		nomes.forEach(System.out::println);
	}
}
