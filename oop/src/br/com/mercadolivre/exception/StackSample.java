package br.com.mercadolivre.exception;

import java.util.ArrayList;

public class StackSample {

	
	public static void main(String[] args) {

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("kenyo");
		lista.add("mauri");
		lista.add("joice");
		lista.add("michele");
		lista.add("betania");
		
		boolean existe = metodo1(lista);
		System.out.println("metodo1 finalizado");
		
		double salario = metodo2(lista, existe);
		System.out.println("metodo2 finalizado");
		
		metodo3(salario);
		System.out.println("metodo3 finalizado");
		
		System.out.println("programa finalizado");
		
	}

	private static boolean metodo1(ArrayList<String> lista) {
		System.out.println("iniciando metodo1");
		return lista.contains("kenyo");
	}
	
	private static double metodo2(ArrayList<String> lista, boolean existe) {
		System.out.println("iniciando metodo2");
		if(existe) {
			for(int i=0; i<lista.size();i++) {
				if(lista.get(i).equals("kenyo")) {
					return 50000;
				}
			}
		}
		return 0;
	}
	
	private static void metodo3(double salario){
		System.out.println("o salario do kenyo é " + salario);
		try {
			metodo4(salario);
			System.out.println("metodo4 finalizado");
		}catch(RuntimeException e) {
			System.out.println("metoo4 caiu fora");
			e.printStackTrace();
		}finally {
			System.out.println("executando finally metodo 3");
		}
		
	}

	private static void metodo4(double salario) throws RuntimeException{
		System.out.println("iniciando metodo4");
		try {
			double result = 5/0;
			System.out.println(result);
		}catch(ArithmeticException e) {
			//gerando o log
			throw new RuntimeException(e);
		}finally {
			System.out.println("executando finally metodo 4");
		}


	}
}
