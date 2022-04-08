package br.com.meli.storage.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Endereco {

	private String logradouro;
	private String complemento;
	private int numero;
	private String bairro;
	private String cep;
	private String municipio;
	@Enumerated(EnumType.STRING)
	private UF uf;
}
