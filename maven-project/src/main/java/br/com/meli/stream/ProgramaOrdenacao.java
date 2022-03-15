package br.com.meli.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProgramaOrdenacao {

	
	
	public static void main(String[] args) {
		
		Anuncio anuncioComBuild = Anuncio.builder().titulo("fiat mobi").data(LocalDate.now()).valor(new BigDecimal(100000)).build();
	
		//sample1();
		
		List<Anuncio> anuncios = Arrays.asList(
				new Anuncio("ps5", LocalDate.of(2022, Month.MARCH, 01), new BigDecimal(5000), true), 
				new Anuncio("iphone 13", LocalDate.of(2022, Month.MARCH, 9), new BigDecimal(15000), false),  
				new Anuncio("fiat mobi", LocalDate.of(2022, Month.MARCH, 3), new BigDecimal(85000), true),  
				new Anuncio("renault kwid", LocalDate.of(2022, Month.MARCH, 2), new BigDecimal(95000), false) 
				);
		//anuncios.stream().filter(a -> a.isHabilitado()).forEach(System.out::println);
		
		anuncios.stream().filter(a -> a.getData().isBefore(LocalDate.of(2022, Month.MARCH, 3))).forEach(System.out::println);
	
		
		//subLista.forEach(System.out::println);

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
