package br.com.mercadolivre.interfaces;

import br.com.mercadolivre.interfaces.entity.Administrativo;
import br.com.mercadolivre.interfaces.entity.Gerente;

public class ProgramaInterfaceSample {

	
	public static void main(String[] args) {
		Autenticador autenticador = new Autenticador();
		
		autenticador.efetuaAutenticacao(new Gerente(), "bearer lsdifhjdjksfhdsl098304938743ojklcjksdhfkajfhdasd234234234234kjshkdjfhsdkjfhsd");
		
		autenticador.efetuaAutenticacao(new Administrativo(), "bearer 98374983743k4jhkjhhkjashdfksjdhfsd30493840394830948jnkljhskdfhda");
	}
}
