package br.com.meli.stream;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Anuncio implements Comparable<Anuncio>{

	private String titulo;
	private LocalDate data;
	private BigDecimal valor;
	private boolean habilitado;
	
	@Override
	public String toString() {
		DecimalFormat decimalFormatter = new DecimalFormat("#,###.00");
		
		return titulo.concat("                ")
					.concat(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
					.concat("       ")
					.concat(decimalFormatter.format(valor.doubleValue()))
					.concat("     ")
					.concat(String.valueOf(habilitado));
	}


	@Override
	public int compareTo(Anuncio p) {
		return titulo.compareTo(p.getTitulo());
	}
}
