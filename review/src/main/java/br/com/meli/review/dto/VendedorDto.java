package br.com.meli.review.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.meli.review.entity.Vendedor;
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
public class VendedorDto {

	@NotNull(message = "cpf obrigatorio")
	private String cpf;

	private String nome;
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)
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

	public static List<VendedorDto> map(List<Vendedor> vendedores) {
		return vendedores.stream().map(e -> map(e)).collect(Collectors.toList());
	}
	
}
