package br.com.mercadolivre.model;

public class ComparingObjectsSample {

	
	public static void main(String[] args) {
		Anuncio iPhoneA = new Anuncio("MLB123", "iphone 13", 300);
		Anuncio iPhoneB = new Anuncio("MLB123", "iphone 13", 300);
		
		System.out.println(iPhoneA.hashCode() +  "      -----      "  + iPhoneB.hashCode());

		if(iPhoneA.equals(iPhoneB.getCodigo())) {
			System.out.println("sao iguais");
		}else {
			System.out.println("sao diferentes");
		}
		
	}
}
