package br.com.mercadolivre.generics;

import java.util.List;

import br.com.mercadolivre.generics.util.ArquivoUtil;

public class AnuncioRepositorio implements Repositorio<Anuncio, String>{

	@Override
	public void salva(Anuncio anuncio) {
		ArquivoUtil<Anuncio> arquivoUtil = new ArquivoUtil<Anuncio>(anuncio);
		arquivoUtil.escreve("anuncios.txt");
	}

	@Override
	public void remove(Anuncio o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Anuncio> listagem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Anuncio obter(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
