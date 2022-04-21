package br.com.meli.review.service.validators;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.exception.MaiorIdadeException;

public class MaiorIdadeValidator implements ValidadorNegocio{
	
	private Vendedor vendedor;

	public MaiorIdadeValidator(Vendedor vendedor){
		this.vendedor = vendedor;
		
	}
	
	@Override
	public void valida() {
		if(this.vendedor.idade() < 18) throw new MaiorIdadeException("o vendedor deve ser maior de idade");
	}

}
