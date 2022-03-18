package br.com.meli.springdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {

	private String titulo;
	private String categoria;
	private double valor;

	
}
