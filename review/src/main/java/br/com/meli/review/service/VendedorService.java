package br.com.meli.review.service;

import br.com.meli.review.entity.Vendedor;

public interface VendedorService {

	Vendedor salvar(Vendedor vendedor);
	Vendedor obter(Long id);
}
