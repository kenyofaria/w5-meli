package br.com.meli.springdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.excetion.AnuncioJaCadastradoException;

@Service
public class AnuncioService {

	private static List<Anuncio> anuncios = Collections.synchronizedList(new ArrayList<Anuncio>());

    static {
		anuncios.addAll(Arrays.asList(
				new Anuncio(1,"MLB123", "Capsulas de cafe", "bebidas", 400),
				new Anuncio(2,"MLB345", "fone JBL","eletronicos", 500),
				new Anuncio(3,"MLB876", "mouse bluetooth", "eletronicos", 600),
				new Anuncio(4,"MLB098", "copo stanley","utilidades",700),
				new Anuncio(5,"MLB789", "jogo de chaves","utilidades", 800),
				new Anuncio(6,"MLB999", "ovo de pascoa","regalia", 900)
			));	
	}
	
	public AnuncioService() {
		System.out.println("criando objeto da classe " + this.getClass().getName());
	}
	
	public synchronized List<Anuncio> lista(String categoria, Double preco){
		if(categoria!=null && !categoria.isEmpty() && preco!=null) {
			return anuncios.stream()
					.filter(a->a.getCategoria().equalsIgnoreCase(categoria))
					.filter(a->a.getValor()<=preco)
					.collect(Collectors.toList());	
		}
		if(categoria!=null && !categoria.isEmpty()) {
			return anuncios.stream()
					.filter(a->a.getCategoria().equalsIgnoreCase(categoria))
					.collect(Collectors.toList());
		}
		if(preco!=null) {
			return anuncios.stream()
					.filter(a->a.getValor()<=preco)
					.collect(Collectors.toList());	
		}
		
		return anuncios;
	}
	
	
	public synchronized Anuncio obter(String codigo) {
		Optional<Anuncio> optional = anuncios.stream().filter(a->a.getCodigo().equals(codigo)).findFirst();
		return optional.orElse(new Anuncio());
		
//		if(optional.isPresent()) {
//			return optional.get();
//		}else {
//			return new Anuncio();
//		}
	}
	
	private boolean anuncioExistente(Anuncio anuncio) {
		return anuncios.stream()
				.anyMatch(a -> a.getTitulo().equals(anuncio.getTitulo()) && a.getValor() == anuncio.getValor());
	}
	
	public synchronized void salvar(Anuncio anuncio) {
		if(anuncioExistente(anuncio))
			throw new AnuncioJaCadastradoException("anuncio já cadastrado");
		anuncios.add(anuncio);
	}
}
