package br.com.meli.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {

	private Integer id;
	private String codigo;
	private String titulo;
	private String categoria;
	private double valor;

	@Override
	public String toString() {
		return String.valueOf(id).concat(";").concat(codigo).concat(";")
				.concat(titulo).concat(";").concat(categoria).concat(";").concat(String.valueOf(valor));
	}
}
