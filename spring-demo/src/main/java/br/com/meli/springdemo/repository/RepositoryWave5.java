package br.com.meli.springdemo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWave5 <T>{

	void insere(T t);
	T obter(String codigo);
	List<T> lista();
	
}
