package br.com.meli.springdemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.springdemo.dto.AnuncioDTO;
import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.service.AnuncioService;

@RestController
public class MyController {
	
	@Autowired
	private AnuncioService anuncioService;

	public MyController() {
		System.out.println("criando objeto da classe " + this.getClass().getName());
		//anuncioService = new AnuncioService();
	}

	//respondendo a uma chamada get http
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	
	@GetMapping("/anuncios")
	public ResponseEntity<List<AnuncioDTO>> retorna(@RequestParam(required = false, name="c") String categoria,
			                     @RequestParam(required = false, name="p") Double preco) {
		List<AnuncioDTO> result = AnuncioDTO.converte(anuncioService.lista(categoria, preco));
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/anuncios/{codigo}")
	public ResponseEntity<AnuncioDTO> obter(@PathVariable String codigo){
		Anuncio anuncio = anuncioService.obter(codigo);
		return ResponseEntity.ok(new AnuncioDTO().converte(anuncio));
	}
	
	@PostMapping("/anuncios")
	public ResponseEntity<AnuncioDTO> salvar(@RequestBody AnuncioDTO dto, UriComponentsBuilder uriBuilder) {
		Anuncio anuncio = dto.converte();
		anuncioService.salvar(anuncio);
		//esta URI sinaliza ao cliente o caminho a ser usado para recuperar o recurso que esta sendo criado.
		URI uri = uriBuilder
				.path("/anuncios/{id}")
				.buildAndExpand(anuncio.getCodigo())
				.toUri();
		AnuncioDTO d = dto.converte(anuncio);
		return ResponseEntity.created(uri).body(d); 
	}
	
	
}
