package br.com.meli.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

}
