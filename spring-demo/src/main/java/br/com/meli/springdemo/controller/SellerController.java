package br.com.meli.springdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.springdemo.service.AnuncioService;

@RestController
public class SellerController {

	@Autowired
	private AnuncioService anuncioService;
	
	public SellerController() {
		System.out.println("criando objeto da classe " + this.getClass().getName());
		//anuncioService = new AnuncioService();
	}
	
	@GetMapping("/sellers")
	public ResponseEntity<List<String>> obterSellers(){
		return ResponseEntity.ok(Arrays.asList("mauri", "michele", "joice", "kenyo"));
	}
	
}
