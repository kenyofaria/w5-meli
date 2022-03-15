package br.com.meli.singleton;

public class SingletonDemo {

	
	
	public static void main(String[] args) {
		Anuncio a = Anuncio.getInstance();
		a.setValor("valor 1");
		System.out.println(a.getValor());
		
		Anuncio b = Anuncio.getInstance();
		System.out.println(b.getValor());
		
		Anuncio c = Anuncio.getInstance();
		System.out.println(c.getValor());
		
		Anuncio d = Anuncio.getInstance();
		System.out.println(d.getValor());
		
	}
}
