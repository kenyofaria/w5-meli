package br.com.meli.springdemo.excetion.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.meli.springdemo.excetion.AnuncioJaCadastradoException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = AnuncioJaCadastradoException.class)
	protected ResponseEntity<Object> handleAnuncioException(AnuncioJaCadastradoException ex) {
		String bodyOfResponse = ex.getMessage();
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
}
