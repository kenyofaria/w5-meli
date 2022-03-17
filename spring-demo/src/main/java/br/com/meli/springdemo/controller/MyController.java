package br.com.meli.springdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	//respondendo a uma chamada get http
	@GetMapping("/ping")
	@ResponseBody
	public String esteNomeNaoTemNada() {
		return "pong";
	}
	
	@GetMapping("/marianas")
	@ResponseBody
	public String marianas() {
		return "mariana 1 and mariana 2";
	}
	
	@GetMapping("/hiro")
	@ResponseBody
	public List<String> pegaLivrosDoHiro(@RequestParam String tipo) {
		if(tipo!=null) {
			if(tipo.equalsIgnoreCase("financeiro"))
				return Arrays.asList("A Revolta de Atlas", "Analise tecnica dos mercados", "Pai rico pai pobre", "A ética da liberdade");
		}
		return Arrays.asList("1984", "a revolucao dos bichos", "cristianismo puro e simples");
	}
	
	@ResponseBody
	@GetMapping("/anuncios")
	public Anuncio retorna() {
		return new Anuncio("PS5", 5500);
	}
	
}
