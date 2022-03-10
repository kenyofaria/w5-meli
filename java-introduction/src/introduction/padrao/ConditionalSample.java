package introduction.padrao;

import java.util.Scanner;

public class ConditionalSample {

	private static void ifSample() {
		int idadeKenyo = 27;
		boolean mentiroso = false;

		if (idadeKenyo <= 30) {
			System.out.println("mentira");
			mentiroso = true;
			System.out.println(mentiroso);
		} else {
			System.out.println("podemos conversar");
		}
	}

	private static void whileAndSwitchSample() {
		Scanner console = new Scanner(System.in);
		int valor = 1;
		
		while(valor<=2) {
			System.out.println("entre com um numero entre 0 e 2");
			valor = console.nextInt();
			switch (valor) {
			case 0:
				System.out.println("o valor informado é zero");
				break;
			case 1:
				System.out.println("o valor informado é hum");
				break;
			case 2:
				System.out.println("o valor informado é dois");
				break;
			default:
				System.out.println("nao reconheco o valor");
				break;
			}
			
		}
		console.close();
	}
	
	public static void main(String[] args) {
		// ifSample();

		whileAndSwitchSample();
	}


}
