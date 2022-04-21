package br.com.meli.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.review.entity.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

}
