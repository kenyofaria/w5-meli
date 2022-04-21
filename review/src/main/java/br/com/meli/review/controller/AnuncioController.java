package br.com.meli.review.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.review.dto.AnuncioDto;
import br.com.meli.review.entity.Anuncio;
import br.com.meli.review.service.AnuncioServiceImpl;
import br.com.meli.review.service.VendedorService;

@RestController
@RequestMapping(AnuncioController.baseUri)
public class AnuncioController {

	public static final String baseUri = "/anuncio";
	
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private AnuncioServiceImpl anuncioService;
	
	@PostMapping
	public ResponseEntity<AnuncioDto> criarAnuncio(@RequestBody AnuncioDto dto, UriComponentsBuilder uriBuilder){
		Anuncio anuncio = dto.map(vendedorService);
		anuncio = anuncioService.salva(anuncio);
		
		URI uri = uriBuilder
				.path(AnuncioController.baseUri.concat("/{id}"))
				.buildAndExpand(anuncio.getId())
				.toUri();
		
		AnuncioDto d = AnuncioDto.map(anuncio);
		return ResponseEntity.created(uri).body(d); 
	}
}
