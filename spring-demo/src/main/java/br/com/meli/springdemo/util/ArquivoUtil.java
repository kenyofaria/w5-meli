package br.com.meli.springdemo.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoUtil<T> {

	private T tipo;

	public ArquivoUtil(T tipo) {
		this.tipo = tipo;
	}
	
	public ArquivoUtil() {
		
	}
	
	public void escreve(String arquivo) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo, true));
			bufferedWriter.append(tipo.toString());
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> leitura(String arquivo){
		Scanner scanner;
		List<String> result = new ArrayList<String>();
		try {
			scanner = new Scanner(new FileInputStream(arquivo));
			while(scanner.hasNext()) {
				result.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return result;
	}
}
