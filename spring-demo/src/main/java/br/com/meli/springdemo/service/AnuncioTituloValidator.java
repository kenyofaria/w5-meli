package br.com.meli.springdemo.service;

import br.com.meli.springdemo.entity.Anuncio;

public class AnuncioTituloValidator implements Validador{

	private Anuncio anuncio;

	public AnuncioTituloValidator(Anuncio anuncio) {
		this.anuncio = anuncio;

	}

	@Override
	public void valida() throws ValidacaoException {
		if(anuncio.getTitulo().length() < 5)
			throw new ValidacaoException("titulo precisa ter tamanho maior que 4");
	}

}
