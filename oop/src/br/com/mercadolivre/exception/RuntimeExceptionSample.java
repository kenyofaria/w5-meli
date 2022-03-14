package br.com.mercadolivre.exception;

public class RuntimeExceptionSample {

	
	
	public static void main(String[] args) {
		int numerador = 10;
		int denominador = 2;
		double[] vetor = {5, 10};
		
		try {
			double result = numerador/denominador;
			System.out.println(result);
			vetor[2] = result;
		}catch(ArithmeticException e) {
			System.out.println("operacao ilegal - divisao por zero");
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException  e) {
			System.out.println("operacao ilegal - estouro do vetor");
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("corram para as montanhas, o mundo estah acabando!!");
			System.out.println(e.getMessage());
		}
		
	}

	
	
}
