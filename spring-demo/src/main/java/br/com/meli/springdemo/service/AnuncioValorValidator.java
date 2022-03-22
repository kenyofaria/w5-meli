package br.com.meli.springdemo.service;

import br.com.meli.springdemo.entity.Anuncio;

public class AnuncioValorValidator implements Validador{

	
	private Anuncio anuncio;


	public AnuncioValorValidator(Anuncio anuncio) {
		this.anuncio = anuncio;
	}


	@Override
	public void valida() throws ValidacaoException {
		if(anuncio.getValor() < 10)
			throw new ValidacaoException("o valor minimo para o anuncio é 10");
		
	}
	
	


}
