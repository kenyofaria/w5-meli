package br.com.meli.review.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private char sexo;
	
	public int idade() {
		if(dataNascimento == null) {
			return 0;
		}
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
}
