package br.com.meli.springdemo.dto;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import br.com.meli.springdemo.entity.Anuncio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(value = { "categoria" })
public class AnuncioDTO {
	
	private String titulo;
	private Double valor;
    private String categoria;
	

	public Anuncio converte() {
		int numero = ThreadLocalRandom.current().nextInt(100, 999);
		return new Anuncio(null, "MLB".concat(String.valueOf(numero)),  this.titulo, this.categoria, this.valor);
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
