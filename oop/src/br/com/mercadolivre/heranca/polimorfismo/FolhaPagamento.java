package br.com.mercadolivre.heranca.polimorfismo;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.mercadolivre.heranca.Funcionario;

public class FolhaPagamento {

	private BigDecimal totalSalario = new BigDecimal(0);
	private BigDecimal totalRetencoes = new BigDecimal(0);
	private BigDecimal totalBonificacoes = new BigDecimal(0);

	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public void adiciona(Funcionario funcionario) {
		
		funcionarios.add(funcionario);
		
		totalSalario = totalSalario.add(funcionario.getSalario());
		totalRetencoes = totalRetencoes.add(funcionario.getDescontos());
		totalBonificacoes = totalBonificacoes.add(funcionario.getBonificacao());
	}
	

	public BigDecimal getTotalSalario() {
		return totalSalario;
	}

	public BigDecimal getTotalRetencoes() {
		return totalRetencoes;
	}

	public BigDecimal getTotalBonificacoes() {
		return totalBonificacoes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	@Override
	public String toString() {
		return String.valueOf(totalSalario)
				.concat("  |  ")
				.concat(String.valueOf(totalRetencoes))
				.concat("  |  ")
				.concat(String.valueOf(totalBonificacoes));
	}
}
