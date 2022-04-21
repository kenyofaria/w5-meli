package br.com.meli.review.service.validators;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.exception.DuplicidadeCpfException;
import br.com.meli.review.repository.VendedorRepository;

public class DuplicidadeCpfValidator implements ValidadorNegocio{
	
	private Vendedor vendedor;
	private VendedorRepository vendedorRepository;

	public DuplicidadeCpfValidator(Vendedor vendedor, VendedorRepository vendedorRepository){
		this.vendedor = vendedor;
		this.vendedorRepository = vendedorRepository;
		
	}
	
	@Override
	public void valida() {
		Vendedor vendedorExistente = vendedorRepository.findByCpf(vendedor.getCpf());
		if(vendedorExistente != null && vendedorExistente.getId() > 0) throw new DuplicidadeCpfException("cpf em uso");
	}

}
