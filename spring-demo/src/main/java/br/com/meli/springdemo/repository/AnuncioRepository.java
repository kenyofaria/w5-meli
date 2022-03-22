package br.com.meli.springdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.springdemo.entity.Anuncio;
import br.com.meli.springdemo.util.ArquivoUtil;

@Repository
public class AnuncioRepository implements RepositoryWave5<Anuncio>{

	private static final String ANUNCIOS_TXT = "anuncios.txt";
	private ArquivoUtil<Anuncio> arquivoUtil;
	
	@Override
	public void insere(Anuncio anuncio) {
		 arquivoUtil = new ArquivoUtil<Anuncio>(anuncio);
		 arquivoUtil.escreve(ANUNCIOS_TXT);
		
	}
	//SOLID

	@Override
	public Anuncio obter(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anuncio> lista() {
		arquivoUtil = new ArquivoUtil<Anuncio>();
		List<String> registros = arquivoUtil.leitura(ANUNCIOS_TXT);
		List<Anuncio> result = new ArrayList<Anuncio>();
		registros.forEach(r->{
			String[] campos = r.split(";");
			Anuncio anuncio = new Anuncio(Integer.valueOf(campos[0]), campos[1], campos[2], campos[3], Double.valueOf(campos[4]));
			result.add(anuncio);
		});
		return result;
	}

}
