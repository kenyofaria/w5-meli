package introduction.padrao;

public class StringSample {

	
	public static void main(String[] args) {
		String nome = "Kenyo Abadio Crosara Faria";
		
		char a = nome.charAt(0);
		char b = nome.charAt(10);
		System.out.println(a + "" + b);
		
		System.out.println(nome.subSequence(2, 5));
		System.out.println(nome.substring(2, 5));
		
		System.out.println(nome.contains("y o"));
	}
}
