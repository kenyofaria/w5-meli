package br.com.meli.storage.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.model.Anuncio;
import br.com.meli.storage.model.UF;
import br.com.meli.storage.model.Vendedor;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>{

	List<Anuncio> findByVendedor(Vendedor vendedor);
	
	@Query(value="from Anuncio a where a.preco >= :precoInicial and a.preco<= :precoFinal")
	List<Anuncio> findByPreco(BigDecimal precoInicial, BigDecimal precoFinal ); //caso esta consulta retorne mais de um objeto, uma excecao é lancada
	
	//JPQL
	@Query(value = "from Anuncio a where a.vendedor.endereco.uf = :p")
	List<Anuncio> retrieveBySellersUf(@Param(value = "p") UF uf);
}
