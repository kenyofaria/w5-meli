package br.com.meli.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>{

}
