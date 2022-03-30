package br.com.meli.springdemo.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.springdemo.dto.AnuncioDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class AnuncioIntegrationTest {

	@Value( "${pathstorefile}" )
	private String arquivoTest;
	
	@Autowired
	private MockMvc mvc;
	
	@BeforeEach
	public void init() throws IOException {
		Files.deleteIfExists(Paths.get(arquivoTest));
	}
	
	@Test
	public void deveCadastrarUmAnuncio() throws JsonProcessingException {

		AnuncioDTO dto = AnuncioDTO.builder().titulo("jogo de chaves").categoria("ferramentas").valor(300.0).build();
		
		String payload = new ObjectMapper().writeValueAsString(dto); //serializando o objeto
		
		try {
			mvc.perform(MockMvcRequestBuilders
					.post("/anuncios")
					.contentType(MediaType.APPLICATION_JSON)
					.content(payload)
				).andExpect(MockMvcResultMatchers.status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deveObterUmAnuncioPeloCodigo() throws Exception {
		
			AnuncioDTO anuncioCadastrado = criaAnuncio();
		
			MvcResult result = mvc.perform(MockMvcRequestBuilders
					.get("/anuncios/{codigo}", anuncioCadastrado.getCodigo())					
				).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			String jsonReturned = result.getResponse().getContentAsString();
			AnuncioDTO dto = new ObjectMapper().readValue(jsonReturned, AnuncioDTO.class);
			
			assertEquals(anuncioCadastrado.getCodigo(), dto.getCodigo());
	}

	private AnuncioDTO criaAnuncio()
			throws Exception, UnsupportedEncodingException, JsonProcessingException, JsonMappingException {
		String payLoad = "{\n"
				+ "    \"titulo\":\"skate\",\n"
				+ "    \"categoria\":\"Brinquedos\",\n"
				+ "    \"valor\": 1000\n"
				+ "    }";

		MvcResult resultAnuncio = mvc.perform(MockMvcRequestBuilders
				.post("/anuncios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payLoad)
			).andReturn();
		
		String jsonAnuncio = resultAnuncio.getResponse().getContentAsString();
		
		AnuncioDTO anuncioCadastrado = new ObjectMapper().readValue(jsonAnuncio, AnuncioDTO.class);
		return anuncioCadastrado;
	}
	
}
