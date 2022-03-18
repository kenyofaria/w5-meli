package br.com.meli.springdemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private static List<Anuncio> anuncios = new ArrayList<Anuncio>();

	static {
		anuncios.addAll(Arrays.asList(
				new Anuncio("Capsulas de cafe", "bebidas", 400),
				new Anuncio("fone JBL","eletronicos", 500),
				new Anuncio("mouse bluetooth", "eletronicos", 600),
				new Anuncio("copo stanley","utilidades",700),
				new Anuncio("jogo de chaves","utilidades", 800),
				new Anuncio("ovo de pascoa","regalia", 900)
			));	
	}
	
	//respondendo a uma chamada get http
	@GetMapping("/ping")
	public String esteNomeNaoTemNada() {
		return "pong";
	}
	
	@GetMapping("/marianas")
	public String marianas() {
		return "mariana 1 and mariana 2";
	}
	
	@GetMapping("/hiro")
	public List<String> pegaLivrosDoHiro(@RequestParam(name = "tipo", required = false) String t) {
		if(t!=null) {
			if(t.equalsIgnoreCase("financeiro"))
				return Arrays.asList("A Revolta de Atlas", "Analise tecnica dos mercados", "Pai rico pai pobre", "A ética da liberdade");
		}
		return Arrays.asList("1984", "a revolucao dos bichos", "cristianismo puro e simples");
	}
	
	@GetMapping("/anuncios")
	public List<Anuncio> retorna(@RequestParam(required = false, name="c") String categoria,
			                     @RequestParam(required = false, name="p") Double preco) {
		
		if(categoria!=null && !categoria.isEmpty()) {
			if(preco!=null) {
				return anuncios.stream()
				.filter(a->a.getCategoria().equalsIgnoreCase(categoria))
				.filter(a->a.getValor()<=preco)
				.collect(Collectors.toList());
			}
			return anuncios.stream()
					.filter(a->a.getCategoria().equals(categoria))
					.collect(Collectors.toList());
		}
		if(preco!=null) {
			return anuncios.stream()
					.filter(a->a.getValor()<=preco)
					.collect(Collectors.toList());	
		}
		return anuncios;
	}
	
	@GetMapping("/anuncios/ate/{p}")
	public List<Anuncio> anuncios(@PathVariable(name = "p") double preco){
		return anuncios.stream().filter(a -> a.getValor() <= preco).collect(Collectors.toList());
	}
	
	@PostMapping("/anuncios")
	public String salvar(@RequestBody Anuncio anuncio) {
		anuncios.add(anuncio);
		return anuncio.getTitulo().concat(" cadastrado com sucesso");
	}
	
	
	
	
}
