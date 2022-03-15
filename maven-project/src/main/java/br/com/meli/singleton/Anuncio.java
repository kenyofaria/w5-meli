package br.com.meli.singleton;

public class Anuncio {

	   private static Anuncio instance = new Anuncio();
	   
	   private String valor;

	   private Anuncio(){
		   
	   }

	   public static Anuncio getInstance(){
	      return instance;
	   }
  
	   
	   public void setValor(String valor) {
		   this.valor = valor;
	   }
	   
	   public String getValor() {
		   return this.valor;
	   }
}
