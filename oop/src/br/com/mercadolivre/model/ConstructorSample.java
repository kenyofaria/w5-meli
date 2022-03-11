package br.com.mercadolivre.model;

public class ConstructorSample {

	
	public static void main(String[] args) {
		Anuncio anuncio = new Anuncio("MLB98734", 230, "monitor lg", 30000);
		
		System.out.println(anuncio.toString());
	}
}
