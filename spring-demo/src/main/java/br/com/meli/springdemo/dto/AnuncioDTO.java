package br.com.meli.springdemo.dto;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.meli.springdemo.entity.Anuncio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

//@JsonIgnoreProperties(value = { "categoria" })
public class AnuncioDTO {
	
	
	@NotNull(message = "título é obrigatório")
	@NotBlank(message = "título é obrigatório")
	@NotEmpty(message = "título é obrigatório")
	@Size(min = 5, max = 255, message="o título deve ter tamanho entre 5 e 255 caracteres")
	private String titulo;
	@NotNull(message = "valor é obrigatório")
	private Double valor;
    private String categoria;
	

	public Anuncio converte() {
		int numero = ThreadLocalRandom.current().nextInt(100, 999);
		return new Anuncio(numero, "MLB".concat(String.valueOf(numero)),  this.titulo, this.categoria, this.valor);
	}
	
	public AnuncioDTO converte(Anuncio anuncio) {
		this.titulo = anuncio.getTitulo();
		this.valor = anuncio.getValor();
		this.categoria = anuncio.getCategoria();
		return this;
	}
		
	public static List<AnuncioDTO> converte(List<Anuncio> anuncios) {
		return anuncios.stream().map(a -> new AnuncioDTO(a.getTitulo(), a.getValor(), a.getCategoria())).collect(Collectors.toList());
	}
}
