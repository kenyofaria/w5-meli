package br.com.meli.springdemo.service;

import br.com.meli.springdemo.entity.Anuncio;

public class AnuncioCategoriaValidator implements Validador{

	private Anuncio anuncio;

	public AnuncioCategoriaValidator(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	@Override
	public void valida() throws ValidacaoException {
		if(anuncio.getCategoria().isEmpty())
			throw new ValidacaoException("categoria é obrigatoria");
		
	}

}
