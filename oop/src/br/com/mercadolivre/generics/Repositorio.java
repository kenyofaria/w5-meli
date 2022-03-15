package br.com.mercadolivre.generics;

import java.util.List;

public interface Repositorio <T, U>{
	
	void salva(T o);
	void remove(T o);
	List<T> listagem();
	T obter(U id);
}
