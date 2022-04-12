package br.com.meli.storage.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.meli.storage.model.Anuncio;
import br.com.meli.storage.model.Vendedor;
import br.com.meli.storage.repository.AnuncioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnuncioService {
	
	private AnuncioRepository anuncioRepository;

	public Anuncio salvar(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}
	
	public List<Anuncio> listar(){
		return anuncioRepository.findAll(); //dependendo do numero de acessos simuntaneos a este recurso, faça a ordenacao programaticamente
	}
	
	public List<Anuncio> listar(Vendedor vendedor){
		if(vendedor.getId()==null) 
			throw new RuntimeException("id obrigatorio");
		return anuncioRepository.findByVendedor(vendedor);
	}
	public List<Anuncio> listar(BigDecimal precoInicial, BigDecimal precoFinal){
		if(precoInicial==null || precoFinal==null) 
			throw new RuntimeException("os precos sao obrigatorios");
		
		if(precoFinal.compareTo(precoInicial) == -1)
			 throw new RuntimeException("o preco final nao deve ser maior que o preco inicial");

		return anuncioRepository.findByPreco(precoInicial, precoFinal);
	}
	
	
}
