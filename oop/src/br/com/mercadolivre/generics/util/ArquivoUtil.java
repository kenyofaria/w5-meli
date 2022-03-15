package br.com.mercadolivre.generics.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil<T> {

	private T tipo;

	public ArquivoUtil(T tipo) {
		this.tipo = tipo;
	}
	
	public void escreve(String arquivo) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo));
			bufferedWriter.append(tipo.toString());
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
