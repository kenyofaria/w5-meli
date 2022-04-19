package br.com.meli.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.review.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
