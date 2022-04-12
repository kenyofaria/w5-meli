package br.com.meli.storage.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.meli.storage.es.model.Ad;

@Repository
public interface AdRepository extends ElasticsearchRepository<Ad, String>{

	List<Ad> findByTitle(String title);
	List<Ad> findByTitleOrTag(String title, String tag);
	List<Ad> findByCodeOrTitle(String code, String t);
}
