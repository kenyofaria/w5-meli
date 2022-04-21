package br.com.meli.review.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.review.entity.Anuncio;
import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.repository.AnuncioRepository;
import br.com.meli.review.repository.VendedorRepository;

//@SpringBootTest
class AnuncioServiceTest {
	
	@Test
	void deveCadastrarAnuncio() {

		AnuncioRepository anuncioRepository = Mockito.mock(AnuncioRepository.class);
		AnuncioServiceImpl anuncioService = new AnuncioServiceImpl(anuncioRepository);
		Vendedor vendedor = Vendedor.builder().id(1L).build();
		Anuncio anuncio = Anuncio.builder().titulo("").preco(BigDecimal.valueOf(0)).vendedor(vendedor).build();
		Mockito.when(anuncioRepository.save(Mockito.any(Anuncio.class))).thenReturn(anuncio);
		
		anuncio = anuncioService.salva(anuncio);
	    
	    assertNotNull(anuncio);
	}
	


}
