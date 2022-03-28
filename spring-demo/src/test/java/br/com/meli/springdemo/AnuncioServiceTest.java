package br.com.meli.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.repository.AnuncioRepository;
import br.com.meli.springdemo.service.AnuncioService;

@Profile("prod")
public class AnuncioServiceTest {

	
	@Test
	public void deveRetornarTodosOsAnuncios() {
		
		AnuncioRepository repositoryMockado = Mockito.mock(AnuncioRepository.class);
		AnuncioService anuncioService = new AnuncioService(repositoryMockado);

		Anuncio mobi = Anuncio.builder().codigo("MLB87364").titulo("fiat mobi").valor(110000).build();
		Anuncio uno = Anuncio.builder().codigo("MLB34424").titulo("fiat uno").valor(115000).build();
		Anuncio luminaria = Anuncio.builder().codigo("MLB8543w5").titulo("luminaria").valor(1000).build();
		
		List<Anuncio> anunciosExistentes = new ArrayList<Anuncio>();
		anunciosExistentes.add(mobi);
		anunciosExistentes.add(uno);
		anunciosExistentes.add(luminaria);
		
		Mockito.when(repositoryMockado.insere(any(Anuncio.class))).thenReturn(new Anuncio());
		
		//desnecessário, pois nao impacta na realidade da execucao da unidade
		//anuncioService.salvar(mobi);
		//anuncioService.salvar(uno);
		//anuncioService.salvar(luminaria);
		
		Mockito.when(repositoryMockado.lista()).thenReturn(anunciosExistentes);
		
		List<Anuncio> todos = anuncioService.lista(null, null);
		
		Mockito.verify(repositoryMockado, times(1)).lista();
		
		assertEquals(3, todos.size());
		assertEquals("mobi", todos.get(0).getTitulo());
	}
}
