package br.com.meli.springdemo.util;

import java.io.BufferedWriter;
import java.io.File;
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
			File file = getFile(arquivo);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(tipo.toString());
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getFile(String arquivo) throws IOException {
		File file = new File(arquivo);
		if(!file.exists())
			file.createNewFile();
		return file;
	}
	
	public List<String> leitura(String arquivo){
		Scanner scanner;
		List<String> result = new ArrayList<String>();
		try {
			File file = getFile(arquivo);
			scanner = new Scanner(new FileInputStream(file));
			while(scanner.hasNext()) {
				result.add(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
