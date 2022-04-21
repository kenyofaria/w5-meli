package br.com.meli.review.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.repository.VendedorRepository;

class VendedorServiceTest {

	@Autowired
	private VendedorRepository repository;
	
	
	@Test
	void naoDeveCadastrarVendedorQuandoMenorIdade() {

		Vendedor vendedor = Vendedor.builder().cpf("234.098.098-90").nome("vendedor do teste").dataNascimento(LocalDate.parse("2010-08-17"))
				.sexo('M').build();
		VendedorService vs = new VendedorServiceImpl(repository);
		
		RuntimeException result = assertThrows(RuntimeException.class, ()->vs.salvar(vendedor));
		
		assertEquals("o vendedor deve ser maior de idade",result.getMessage());
		
	}
	
	@Test
	void deeveCadastrarVendedorQuandoMaiorIdade() {
		Vendedor vendedor = Vendedor.builder().cpf("234.098.098-90").nome("vendedor do teste").dataNascimento(LocalDate.parse("2000-08-17"))
				.sexo('M').build();
		VendedorRepository mock = Mockito.mock(VendedorRepository.class);
		Mockito.when(mock.save(any(Vendedor.class))).thenReturn(vendedor);
		VendedorService vs = new VendedorServiceImpl(mock);
		
		vs.salvar(vendedor);
		
		Mockito.verify(mock, times(1)).save(vendedor);
	}


}
