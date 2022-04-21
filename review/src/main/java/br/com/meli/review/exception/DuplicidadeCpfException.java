package br.com.meli.review.exception;

public class DuplicidadeCpfException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DuplicidadeCpfException(RuntimeException e) {
		super(e);
	}
	public DuplicidadeCpfException(String mensagem) {
		super(mensagem);
	}
}
