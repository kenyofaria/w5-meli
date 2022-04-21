package br.com.meli.review.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.review.dto.VendedorDto;
import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.service.VendedorService;

@RestController
@RequestMapping(VendedorController.baseUri)
public class VendedorController {
	
	public static final String baseUri = "/vendedor";

	@Autowired
	private VendedorService vendedorService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> obter(@PathVariable Long id){
		Vendedor vendedorExistente = vendedorService.obter(id);
		VendedorDto result = VendedorDto.map(vendedorExistente);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<VendedorDto>> obter(){
		List<Vendedor> vendedores = vendedorService.listagem();
		return ResponseEntity.ok(VendedorDto.map(vendedores));
		
	}
	
	@PostMapping
	public ResponseEntity<VendedorDto> cadastrar(@Valid @RequestBody VendedorDto dto, UriComponentsBuilder uriBuilder){
		Vendedor vendedor = dto.map();
		vendedorService.salvar(vendedor);
		
		URI uri = uriBuilder
				.path(VendedorController.baseUri.concat("/{id}"))
				.buildAndExpand(vendedor.getId())
				.toUri();
		
		VendedorDto d = VendedorDto.map(vendedor);
		return ResponseEntity.created(uri).body(d); 
	}
	
	@PutMapping
	public ResponseEntity<VendedorDto> atualizar(@Valid @RequestBody VendedorDto dto){
		Vendedor vendedor = dto.map();
		Vendedor novoVendedor = vendedorService.atualizar(vendedor);
		return ResponseEntity.ok(VendedorDto.map(novoVendedor));
	}
	
	
}
