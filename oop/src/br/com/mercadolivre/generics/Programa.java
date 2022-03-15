package br.com.mercadolivre.generics;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Programa {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		//problema();
		
		//solucao();
		
		//genericsSample();
		
		//VendaService vendaService = new VendaService();
		//vendaService.listagem(Mes.valueOf(null));
		
		System.out.println(Mes.JANEIRO.ordinal());
		System.out.println(Mes.JANEIRO.getNumero());
		
	}

	private static void genericsSample() {
		//		Anuncio anuncio = new Anuncio("MLB09823", "ps 5", 5000);
		//		AnuncioRepositorio repositorio = new AnuncioRepositorio();
		//		repositorio.salva(anuncio);
				
				VendedorRepositorio repo = new VendedorRepositorio();
				repo.salva(new Vendedor("MLB123", "333.343.532-22", "mauri"));
				System.out.println("persistencia realizada");
	}

	private static void solucao() {
		ArrayList<Integer> array = new ArrayList();
		array.add(1);
		array.add(2);
		array.add(1);
		array.add(2);
		
		
		int acumulador = 0;
		//a partir do java 1.5, as generics lhe permitem especificar tipos/parametros permitidos em uma estrutura
		for(int i=0; i<array.size(); i++) {
			acumulador = acumulador + array.get(i);
		}
	}

	private static void problema() {
		ArrayList array = new ArrayList();
		array.add(new BigDecimal(10));
		array.add(new BigDecimal(10));
		array.add(1);
		array.add(2);
		array.add("");
		
		
		int acumulador = 0;
		//até o java 4 (1.4) era necessaria a realizacao de casting
		for(int i=0; i<array.size(); i++) {
			acumulador = acumulador + (Integer) array.get(i);
		}
	}
}
