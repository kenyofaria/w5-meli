package br.com.meli.ordenacao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Anuncio implements Comparable<Anuncio>{

	private String titulo;
	private LocalDate data;
	private BigDecimal valor;
	
	
	@Override
	public String toString() {
		DecimalFormat decimalFormatter = new DecimalFormat("#,###.00");
		
		return titulo.concat("                ")
				.concat(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.concat("       ")
				.concat(decimalFormatter.format(valor.doubleValue()));
	}


	@Override
	public int compareTo(Anuncio p) {
		return titulo.compareTo(p.getTitulo());
	}
}
