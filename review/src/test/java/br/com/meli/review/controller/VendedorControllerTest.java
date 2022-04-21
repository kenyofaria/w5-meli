package br.com.meli.review.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.review.dto.VendedorDto;

@SpringBootTest
@AutoConfigureMockMvc
class VendedorControllerTest {
	
	
	@Autowired
	private MockMvc mock;

	
	@Test
	public void deveCadastrarVendedor() throws Exception {

		String payload = new ObjectMapper().writeValueAsString(VendedorDto.builder().cpf("333.123.111-10").nome("mauri")
				.dataNascimento(LocalDate.parse("2003-01-31")).sexo('m').build());
		
		mock.perform(MockMvcRequestBuilders
				.post("/vendedor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload)
			).andExpect(MockMvcResultMatchers.status().isCreated());
		
		MvcResult result = mock.perform(MockMvcRequestBuilders
				.get("/vendedor/1")
			).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String jsonRetorno = result.getResponse().getContentAsString();
		
		
		VendedorDto dto = new ObjectMapper().readValue(jsonRetorno, VendedorDto.class);
		assertEquals("333.123.111-10", dto.getCpf());
		
	}
	
	@Test
	public void deveListarTodosVendores() throws Exception {
		populaVendedores();
		
		MvcResult result = mock.perform(MockMvcRequestBuilders
				.get("/vendedor/lista")
			).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String jsonRetorno = result.getResponse().getContentAsString();
		
		VendedorDto[] vendedores = new ObjectMapper().readValue(jsonRetorno, VendedorDto[].class);
		assertEquals(3,vendedores.length);
	}
	
	private void populaVendedores() throws Exception{
		String v1 = new ObjectMapper().writeValueAsString(VendedorDto.builder().cpf("333.123.111-10").nome("mauri")
				.dataNascimento(LocalDate.parse("2003-01-31")).sexo('m').build());
		
		String v2 = new ObjectMapper().writeValueAsString(VendedorDto.builder().cpf("345.123.111-10").nome("michele")
				.dataNascimento(LocalDate.parse("2003-01-31")).sexo('f').build());
		
		String v3 = new ObjectMapper().writeValueAsString(VendedorDto.builder().cpf("345.233.111-10").nome("kenyo")
				.dataNascimento(LocalDate.parse("2003-01-31")).sexo('m').build());
		
	
		List<String> vendedores = Arrays.asList(v1,v2,v3);
		
		vendedores.forEach(payLoad -> {
				try {
					mock.perform(MockMvcRequestBuilders
							.post("/vendedor")
							.contentType(MediaType.APPLICATION_JSON)
							.content(payLoad));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		);
		
	}

}
