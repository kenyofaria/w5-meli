package br.com.meli.review.service;

import java.util.List;

import br.com.meli.review.entity.Vendedor;

public interface VendedorService {

	Vendedor salvar(Vendedor vendedor);
	Vendedor obter(Long id);
	Vendedor atualizar(Vendedor vendedor);
	List<Vendedor> listagem();
}
