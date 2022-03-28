package br.com.meli.springdemo.excetion.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.meli.springdemo.dto.ErrorDTO;
import br.com.meli.springdemo.excetion.AnuncioJaCadastradoException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = AnuncioJaCadastradoException.class)
	protected ResponseEntity<Object> handleAnuncioException(AnuncioJaCadastradoException ex) {
		String bodyOfResponse = ex.getMessage();
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException e) {
		List<ObjectError> erros = e.getBindingResult().getAllErrors();
		List<ErrorDTO> results = new ArrayList<ErrorDTO>();
		erros.forEach(x ->{
			ErrorDTO error = new ErrorDTO("campo inválido", x.getDefaultMessage());
			results.add(error);
		});
        return new ResponseEntity<>(results, HttpStatus.BAD_REQUEST);
    }
}
