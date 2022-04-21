package br.com.meli.review.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.meli.review.entity.Vendedor;
import br.com.meli.review.repository.VendedorRepository;
import br.com.meli.review.service.validators.ValidadorNegocio;
import br.com.meli.review.service.validators.DuplicidadeCpfValidator;
import br.com.meli.review.service.validators.MaiorIdadeValidator;

@Service
public class VendedorServiceImpl implements VendedorService{

	
	private List<ValidadorNegocio> validadores;
	
	private final VendedorRepository vendedorRepository;

	
	public VendedorServiceImpl(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	private void initializaValidadores(Vendedor vendedor) {
		validadores = Arrays.asList(new MaiorIdadeValidator(vendedor), new DuplicidadeCpfValidator(vendedor, vendedorRepository));
	}
	
	@Override
	public Vendedor salvar(Vendedor vendedor) {
		initializaValidadores(vendedor);
		this.validadores.forEach(v -> v.valida());
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Vendedor obter(Long id) {
		Optional<Vendedor> op = this.vendedorRepository.findById(id);
		return op.orElse(new Vendedor());
	}

	@Override
	public Vendedor atualizar(Vendedor vendedor) {
		
		Vendedor vendedorExistente = vendedorRepository.findByCpf(vendedor.getCpf());//vai para o estado managed
		if(vendedorExistente == null) {
			throw new RuntimeException("vendedor inexistente");
		}
		
		vendedorExistente.setDataNascimento(vendedor.getDataNascimento());
		vendedorExistente.setNome(vendedor.getNome());
		vendedorExistente.setSexo(vendedor.getSexo());
		
		return vendedorRepository.save(vendedorExistente);
		
	}

	@Override
	public List<Vendedor> listagem() {
		List<Vendedor> vendedores = vendedorRepository.findAll();
		if(vendedores == null) {
			return new ArrayList<Vendedor>();
		}
		return vendedores;
	}
	
	
}
