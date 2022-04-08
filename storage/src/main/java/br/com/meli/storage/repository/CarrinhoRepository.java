package br.com.meli.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.model.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{

}
