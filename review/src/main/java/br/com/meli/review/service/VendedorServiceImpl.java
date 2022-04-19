package br.com.meli.review.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.repository.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public Vendedor salvar(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor obter(Long id) {
		Optional<Vendedor> op = this.vendedorRepository.findById(id);
		return op.orElse(new Vendedor());
	}
	
	
}
