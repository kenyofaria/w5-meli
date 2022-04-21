package br.com.meli.review.service;

import org.springframework.stereotype.Service;

import br.com.meli.review.entity.Anuncio;
import br.com.meli.review.repository.AnuncioRepository;

@Service
public class AnuncioServiceImpl implements AnuncioService{

	private final AnuncioRepository anuncioRepository;
	
	public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
		super();
		this.anuncioRepository = anuncioRepository;
	}

	public Anuncio salva(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
		
	}

	
}
