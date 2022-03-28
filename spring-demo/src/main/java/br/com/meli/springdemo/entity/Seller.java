package br.com.meli.springdemo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller {

	private String codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String uf;
	
	@Override
	public String toString() {
		return codigo.concat(";").concat(nome).concat(";").concat(dataNascimento.toString());
	}
}
