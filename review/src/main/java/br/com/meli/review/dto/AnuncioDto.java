package br.com.meli.review.dto;

import java.math.BigDecimal;

import br.com.meli.review.entity.Anuncio;
import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.service.VendedorService;
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
public class AnuncioDto {

	private String titulo;
	private BigDecimal preco;
	private Long vendedor;

	public Anuncio map(VendedorService vendedorService) {
		Vendedor vendedor = vendedorService.obter(this.vendedor); //coloca o vendedor no estado managed
		return Anuncio.builder().titulo(this.titulo).preco(this.preco).vendedor(vendedor).build();
	}

	public static AnuncioDto map(Anuncio anuncio) {
		return AnuncioDto.builder().titulo(anuncio.getTitulo()).preco(anuncio.getPreco())
				.vendedor(anuncio.getVendedor().getId()).build();
	}
}
