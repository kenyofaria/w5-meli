package br.com.meli.storage.es.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import br.com.meli.storage.es.model.Ad;
import br.com.meli.storage.es.repository.AdRepository;

@Service
public class AdService {

	@Autowired
	private AdRepository adRepository;
	@Autowired
	private ElasticsearchRestTemplate elasticsearchTemplate;
	
	public Ad create(Ad ad) {
		if(ad.getTitle() == null || ad.getTitle().isEmpty())
			throw new RuntimeException("título é obrigatório");
		if(ad.getId() != null) {
			return update(ad);
		}else {
			return adRepository.save(ad);
		}
	}
	
	private Ad update(Ad ad) {
		Optional<Ad> op = adRepository.findById(ad.getId());
		Ad existingAd = op.orElse(ad);
		existingAd.setCode(ad.getCode());
		existingAd.setPrice(ad.getPrice());
		existingAd.setStock(ad.getStock());
		existingAd.setTag(ad.getTag());
		existingAd.setTitle(ad.getTitle());
		return adRepository.save(existingAd);
	}
	
	public List<Ad> fetchDocuments(String phrase){
		MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(phrase, "title", "tag")
				.operator(Operator.OR)
				.type(MultiMatchQueryBuilder.Type.PHRASE);

		NativeSearchQuery result = new NativeSearchQueryBuilder().withQuery(query).build();

		SearchHits<Ad> search = elasticsearchTemplate.search(result, Ad.class, IndexCoordinates.of("ad"));
		
		List<Ad> list = search.stream().map(r ->
			Ad.builder().code(r.getContent().getCode()).id(r.getContent().getId()).price(r.getContent().getPrice())
					.stock(r.getContent().getStock()).tag(r.getContent().getTag()).title(r.getContent().getTitle())
					.build()
		).collect(Collectors.toList());
		
		return list;
	}
	
//	
//	private void busca2(String termo) {
//		NativeSearchQuery s = new NativeSearchQueryBuilder()
//				  .withQuery(multiMatchQuery(termo)
//				    .field("title")
//				    .field("tag")
//				    .type(MultiMatchQueryBuilder.Type.PHRASE))
//				  .build();
//		
//		SearchHits<Ad> search = elasticsearchTemplate.search(s, Ad.class, IndexCoordinates.of("ad"));
//		search.forEach(a->System.out.println(a.getContent().getTitle()));
//	}
//
//	private void busca1(String termo) {
//		MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(termo, "title", "tag")
//				.operator(Operator.OR)
//				.type(MultiMatchQueryBuilder.Type.PHRASE);
//
//		NativeSearchQuery result = new NativeSearchQueryBuilder().withQuery(query).build();
//
//		SearchHits<Ad> search = elasticsearchTemplate.search(result, Ad.class, IndexCoordinates.of("ad"));
//		search.forEach(a -> System.out.println(a.getContent().getTitle()));
//	}
}
