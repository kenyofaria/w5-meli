package br.com.meli.review.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.meli.review.entity.Vendedor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VendedorDto {

	@NotNull(message = "cpf obrigatorio")
	private String cpf;

	private String nome;

	private LocalDate dataNascimento;

	private char sexo;

	public Vendedor map() {
		return Vendedor.builder().cpf(this.cpf).nome(this.nome).dataNascimento(this.dataNascimento).sexo(this.sexo)
				.build();
	}

	public static VendedorDto map(Vendedor vendedor) {
		return VendedorDto.builder().cpf(vendedor.getCpf()).nome(vendedor.getNome())
				.dataNascimento(vendedor.getDataNascimento()).sexo(vendedor.getSexo()).build();
	}
}
