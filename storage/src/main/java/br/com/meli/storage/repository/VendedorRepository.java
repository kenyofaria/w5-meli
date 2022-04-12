package br.com.meli.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	
	//Page<Vendedor> findByEndereco_uf(UF uf, Pageable pageable);
	
	
	//carros datas alugadas
	
	/**
	 * 
	 * 
	 *{
	 *	placa:"oni4509",
	 *  model:"jeep compass"
	 *  cor:"preta"
	 *  disponivel:""
	 *  alugueis:[{contrato: "34434", dataInicio: "05/02/22", dataFinal: "06/03/22"}, {contrato: "34434", dataInicio: "10/03/22", dataFinal: "06/04/22"}]
	 *} 
	 *
	 * quero saber os carros disponiveis 
	 * 
	 * 
	 */
}
