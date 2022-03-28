package br.com.meli.springdemo.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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
import br.com.meli.springdemo.service.AnuncioCategoriaValidator;
import br.com.meli.springdemo.service.AnuncioDuplicidadeValidator;
import br.com.meli.springdemo.service.AnuncioService;
import br.com.meli.springdemo.service.AnuncioTituloValidator;
import br.com.meli.springdemo.service.AnuncioValorValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Anuncios")
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;

	public AnuncioController() {
		System.out.println("criando objeto da classe " + this.getClass().getName());
		//anuncioService = new AnuncioService();
	}

	//respondendo a uma chamada get http
	@ApiOperation(value = "Check if service is up")
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@ApiOperation(value = "Fetch all existing ads based on params")
	@GetMapping("/anuncios")
	public ResponseEntity<List<AnuncioDTO>> retorna(@RequestParam(required = false, name="c") String categoria,
			                     @RequestParam(required = false, name="p") Double preco) {
		List<AnuncioDTO> result = AnuncioDTO.converte(anuncioService.lista(categoria, preco));
		return ResponseEntity.ok(result);
	}
	
	@ApiOperation(value = "Fetch an especific ad based on code")
	@GetMapping("/anuncios/{codigo}")
	public ResponseEntity<AnuncioDTO> obter(@PathVariable String codigo){
		Anuncio anuncio = anuncioService.obter(codigo);
		return ResponseEntity.ok(new AnuncioDTO().converte(anuncio));
	}
	
	@ApiOperation(value = "Create a new ad passed on body")
	@PostMapping("/anuncios")
	public ResponseEntity<AnuncioDTO> salvar(@Valid @RequestBody AnuncioDTO dto, UriComponentsBuilder uriBuilder) {
		Anuncio anuncio = dto.converte();
			
		anuncioService.salvar(anuncio, Arrays.asList(
				new AnuncioTituloValidator(anuncio),
				new AnuncioCategoriaValidator(anuncio),
				new AnuncioValorValidator(anuncio),
				new AnuncioDuplicidadeValidator(anuncio)
				));
		//esta URI sinaliza ao cliente o caminho a ser usado para recuperar o recurso que esta sendo criado.
		URI uri = uriBuilder
				.path("/anuncios/{id}")
				.buildAndExpand(anuncio.getCodigo())
				.toUri();
		AnuncioDTO d = dto.converte(anuncio);
		return ResponseEntity.created(uri).body(d); 
	}
	
	
}
