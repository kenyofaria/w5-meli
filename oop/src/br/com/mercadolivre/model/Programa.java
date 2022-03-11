package br.com.mercadolivre.model;



public class Programa {

	
	
	public static void main(String[] args) {
		//sample1();
		sample2();
		
		
	}



	private static void sample2() {
		Anuncio lg = new Anuncio();
		lg.setTitulo("monitor LG");
		
		Anuncio samsung = new Anuncio();
		samsung.setTitulo("monitor Samsung");
		
		
		System.out.println(lg.getTitulo());
		System.out.println(samsung.getTitulo());
		
		System.out.println("\n------------------------------\n");
		samsung = lg;
		
		System.out.println(lg.getTitulo());
		System.out.println(samsung.getTitulo());
		
		System.out.println("\n------------------------------\n");
		lg = null;
		
		System.out.println(samsung.getTitulo());
		System.out.println(lg.getTitulo());
	}

	
	
	private static void sample1() {
		Anuncio lg = new Anuncio();
		Anuncio dell = new Anuncio();
		lg.setTitulo("titulo original");
		
		System.out.println("titulo do objeto monitor");
		System.out.println(lg.getTitulo());
		
		System.out.println("titulo do objeto dell");
		System.out.println(dell.getTitulo());
		
		System.out.println("imprimindo o valor referenciado pelas duas variaveis");
		dell.setTitulo("titulo dell");
		System.out.println(dell.getTitulo());
		System.out.println(lg.getTitulo());
	}
}



//monitor.setCodigo("MLB0983434");
//monitor.setEstoque(230);
//monitor.setQuantidadeVendas(30000);
