package br.com.meli.springdemo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.entity.Seller;
import br.com.meli.springdemo.util.ArquivoUtil;

@Repository
public class SellerRepository implements RepositoryWave5<Seller>{

	private static final String ANUNCIOS_TXT = "anuncios.txt";
	private ArquivoUtil<Seller> arquivoUtil;
	
	@Override
	public Seller insere(Seller seller) {
		System.out.println("realizando a insercao do seller no arquivo"); 
		return null;
		//arquivoUtil = new ArquivoUtil<Seller>(seller);
		 //arquivoUtil.escreve(ANUNCIOS_TXT);
	}

	@Override
	public Seller obter(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> lista() {
		// TODO Auto-generated method stub
		return null;
	}

}
