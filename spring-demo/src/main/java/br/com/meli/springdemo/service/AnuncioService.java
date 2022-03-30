package br.com.meli.springdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.repository.AnuncioRepository;
import br.com.meli.springdemo.repository.RepositoryWave5;

@Service
@Profile("test")
public class AnuncioService {

//	private static List<Anuncio> anuncios = Collections.synchronizedList(new ArrayList<Anuncio>());
//
//    static {
//		anuncios.addAll(Arrays.asList(
//				new Anuncio(1,"MLB123", "Capsulas de cafe", "bebidas", 400),
//				new Anuncio(2,"MLB345", "fone JBL","eletronicos", 500),
//				new Anuncio(3,"MLB876", "mouse bluetooth", "eletronicos", 600),
//				new Anuncio(4,"MLB098", "copo stanley","utilidades",700),
//				new Anuncio(5,"MLB789", "jogo de chaves","utilidades", 800),
//				new Anuncio(6,"MLB999", "ovo de pascoa","regalia", 900)
//			));	
//	}
	
	private AnuncioRepository repository;
	
	public AnuncioService(AnuncioRepository repository) {
		this.repository = repository;
	}
	
	public synchronized List<Anuncio> lista(String categoria, Double preco){
		if(categoria!=null && !categoria.isEmpty() && preco!=null) {
			return repository.lista().stream()
					.filter(a->a.getCategoria().equalsIgnoreCase(categoria))
					.filter(a->a.getValor()<=preco)
					.collect(Collectors.toList());	
		}
		if(categoria!=null && !categoria.isEmpty()) {
			return repository.lista().stream()
					.filter(a->a.getCategoria().equalsIgnoreCase(categoria))
					.collect(Collectors.toList());
		}
		if(preco!=null) {
			return repository.lista().stream()
					.filter(a->a.getValor()<=preco)
					.collect(Collectors.toList());	
		}
		
		return repository.lista();
	}
	
	
	public synchronized Anuncio obter(String codigo) {
		Optional<Anuncio> optional = repository.lista().stream().filter(a->a.getCodigo().equals(codigo)).findFirst();
		return optional.orElse(new Anuncio());
	}
	
	private boolean anuncioExistente(Anuncio anuncio) {
		return repository.lista().stream()
				.anyMatch(a -> a.getTitulo().equals(anuncio.getTitulo()));
	}
	
	public synchronized void salvar(Anuncio anuncio, List<Validador> validadores) {
		if(!anuncioExistente(anuncio)) {
			repository.insere(anuncio);
		}else {
			throw new RuntimeException("Anuncio já cadastrado");
		}
	}
	public synchronized Anuncio salvar(Anuncio anuncio) {
		if(!anuncioExistente(anuncio)) {
			return repository.insere(anuncio);
		}else {
			throw new RuntimeException("Anuncio já cadastrado");
		}
	}
}
