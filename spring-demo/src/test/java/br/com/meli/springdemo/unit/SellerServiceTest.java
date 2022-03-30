package br.com.meli.springdemo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.meli.springdemo.entity.Seller;
import br.com.meli.springdemo.repository.SellerRepository;
import br.com.meli.springdemo.service.SellerService;

//@Profile("critico")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
public class SellerServiceTest {

	private SellerService service;

	private SellerRepository sellerRepository; //é um objeto mockado
	
	@BeforeEach
	public void before() {
		this.sellerRepository = Mockito.mock(SellerRepository.class);
		//this.sellerRepository = new SellerRepository();
		this.service = new SellerService(sellerRepository);
	}

	@Order(0)
	@Test
	@Tag("atoa")
	public void primeiroTest() {
		System.out.println("primeiroTest");
		assertTrue(true);
	}

	@Order(1)
	@Test
	public void deveSalvarUmSeller() {

		// setup
		Seller seller = Seller.builder().codigo("MLB987").nome("Kenyo").dataNascimento(LocalDate.parse("1980-02-25"))
				.build();
		Mockito.when(this.sellerRepository.insere(any())).thenReturn(seller);

		// executando a unidade under test
		Seller result = this.service.salva(seller);

		// check
		assertNotNull(result);

	}
	
	@Test
	public void naoDeveSalvarUmSellerQuandoMenorIdade() {
		Seller seller = Seller.builder().codigo("MLB987").nome("Nayara").dataNascimento(LocalDate.parse("2007-02-25"))
				.build();
		RuntimeException result = assertThrows(RuntimeException.class, ()->this.service.salva(seller));
		assertEquals("um vendedor deve ser maior de idade",result.getMessage());
	}

	@Test
	public void deveExcluirUmSeller() {
		boolean result = service.remove("MLB987");
		assertTrue(result);
	}

	@DisplayName(value = "nome que_=   eu_quero")
	@Test
	public void naoDeveExcluirUmSellerQuandoCodigoVazio() {
		
	    Throwable exception = assertThrows(RuntimeException.class,()->service.remove(""));
		
		assertEquals("informe o codigos", exception.getMessage());
	}
}
