package br.com.meli.review.exception;

public class MaiorIdadeException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public MaiorIdadeException(RuntimeException e) {
		super(e);
	}
	public MaiorIdadeException(String mensagem) {
		super(mensagem);
	}
}
