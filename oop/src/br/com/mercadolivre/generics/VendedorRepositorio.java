package br.com.mercadolivre.generics;

import java.util.List;

import br.com.mercadolivre.generics.util.ArquivoUtil;

public class VendedorRepositorio implements Repositorio<Vendedor, String> {

	@Override
	public void salva(Vendedor vendedor) {
		ArquivoUtil<Vendedor> arquivoUtil = new ArquivoUtil<Vendedor>(vendedor);
		arquivoUtil.escreve("vendedores.txt");
	}

	@Override
	public void remove(Vendedor o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendedor> listagem() {
		return null;
	}

	@Override
	public Vendedor obter(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
