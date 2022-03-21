package br.com.meli.springdemo.excetion;

public class AnuncioJaCadastradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1957137827451037216L;

	public AnuncioJaCadastradoException(String mensagem) {
		super(mensagem);
	}
	
}
