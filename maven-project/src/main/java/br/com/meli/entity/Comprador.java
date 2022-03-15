package br.com.meli.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comprador {

	
	private String codigo;
	private String cpf;
	private String nome;
	private char sexo;
	private LocalDate dataNascimento;
	
	
}
