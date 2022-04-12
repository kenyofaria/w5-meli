package br.com.meli.storage;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.IntervalsSourceProvider.Match;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import br.com.meli.storage.es.model.Ad;
import br.com.meli.storage.es.repository.AdRepository;
import br.com.meli.storage.model.Anuncio;
import br.com.meli.storage.model.Carrinho;
import br.com.meli.storage.model.Endereco;
import br.com.meli.storage.model.ItemCarrinho;
import br.com.meli.storage.model.UF;
import br.com.meli.storage.model.Vendedor;
import br.com.meli.storage.repository.AnuncioRepository;
import br.com.meli.storage.repository.CarrinhoRepository;
import br.com.meli.storage.repository.VendedorRepository;
import br.com.meli.storage.service.AnuncioService;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@SpringBootApplication
public class StorageApplication implements CommandLineRunner {

	@Autowired
	private AnuncioService anuncioService;

	@Autowired
	private AnuncioRepository anuncioRepository;

	@Autowired
	private VendedorRepository vendedorRepository;

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	private AdRepository adRepository;

	@Autowired
	private ElasticsearchRestTemplate elasticsearchTemplate;

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<String> tagsFerramentas = Arrays.asList("ferramenta", "construcao");
		List<String> tagsConstrucao = Arrays.asList("construcao");

		Ad chaveFenda = adRepository.save(Ad.builder().code("3540").title("chave de fenda").price(BigDecimal.valueOf(20)).stock(200)
				.tag(tagsFerramentas).build());
		System.out.println("generated id: " + chaveFenda.getId());

		Ad chaveInglesa = adRepository.save(Ad.builder().title("chave inglesa 3540").price(BigDecimal.valueOf(70)).stock(200)
				.tag(tagsFerramentas).build());
		System.out.println("generated id: " + chaveInglesa.getId());

		Ad alicate = adRepository.save(
				Ad.builder().title("alicate").price(BigDecimal.valueOf(90)).stock(200).tag(tagsFerramentas).build());
		System.out.println("generated id: " + alicate.getId());

		Ad parafuso = adRepository.save(Ad.builder().title("parafuso m8x25").price(BigDecimal.valueOf(90)).stock(200)
				.tag(tagsFerramentas).build());
		System.out.println("generated id: " + parafuso.getId());

		Ad cimento = adRepository.save(Ad.builder().title("cimento tocantins").price(BigDecimal.valueOf(40)).stock(20)
				.tag(tagsConstrucao).build());
		System.out.println("generated id: " + parafuso.getId());

		
		adRepository.findByCodeOrTitle("3540","3540").forEach(a->System.out.println(a.getTitle()));
		
		
		
		//adRepository.findByTitleOrTag("construcao");//.forEach(c->System.out.println(c.getTitle()));
		
		
		
		//busca1("construcao");

		//busca2();

		// adRepository.findByTitle("chave").forEach(ad ->
		// System.out.println(ad.getTitle()));

		// criaAnuncios();
		// anuncioService.listar(Vendedor.builder().id(1).build()).forEach(a->System.out.println(a.getTitulo()));

		// anuncioRepository.retrieveBySellersUf(UF.RS).forEach(a->System.out.println(a.getTitulo()));

		// buscaAnunciosPorVendedor();

		// salvandoCarrinhosComItens();

		// alteraVendedorDoAnuncio();
		// criaAnuncio();

		// adicionaAnuncioAUmVendedorExistente();
	}

	private void busca2(String termo) {
		NativeSearchQuery s = new NativeSearchQueryBuilder()
				  .withQuery(multiMatchQuery(termo)
				    .field("title")
				    .field("tag")
				    .type(MultiMatchQueryBuilder.Type.PHRASE))
				  .build();
		
		SearchHits<Ad> search = elasticsearchTemplate.search(s, Ad.class, IndexCoordinates.of("ad"));
		search.forEach(a->System.out.println(a.getContent().getTitle()));
	}

	private void busca1(String termo) {
		MultiMatchQueryBuilder query = new MultiMatchQueryBuilder(termo, "title", "tag")
				.operator(Operator.OR)
				.type(MultiMatchQueryBuilder.Type.PHRASE);

		NativeSearchQuery result = new NativeSearchQueryBuilder().withQuery(query).build();

		SearchHits<Ad> search = elasticsearchTemplate.search(result, Ad.class, IndexCoordinates.of("ad"));
		search.forEach(a -> System.out.println(a.getContent().getTitle()));
	}

	private void buscaAnunciosPorVendedor() {
		List<Anuncio> anuncios = anuncioRepository.findByVendedor(Vendedor.builder().id(2).build());
		anuncios.forEach(a -> System.out.println(a.getTitulo()));
	}

	private void salvandoCarrinhosComItens() {
		Optional<Anuncio> opSandalia = anuncioRepository.findById(1);
		Optional<Anuncio> opBiquini = anuncioRepository.findById(5);

		Carrinho carrinho = Carrinho.builder().dataFechamento(LocalDate.now()).build();

		carrinho.setItens(Arrays.asList(
				ItemCarrinho.builder().preco(opSandalia.get().getPreco()).quantidade(1).carrinho(carrinho)
						.anuncio(opSandalia.get()).build(),
				ItemCarrinho.builder().preco(opBiquini.get().getPreco()).quantidade(1).carrinho(carrinho)
						.anuncio(opBiquini.get()).build()));
		// ItemCarrinho.builder().preco(BigDecimal.valueOf(200)).quantidade(1).build()));

		carrinhoRepository.save(carrinho);
	}

	private void alteraVendedorDoAnuncio() {
		Optional<Anuncio> op = anuncioRepository.findById(3); // levando o anuncio ao estado managed
		Anuncio a = op.get();
		a.setVendedor(vendedorRepository.findById(2).get()); // levando o vendedor 2 ao estado managed
		anuncioRepository.save(a);
	}

	private void adicionaAnuncioAUmVendedorExistente() {
		Optional<Vendedor> opVendedor = vendedorRepository.findById(1);
		Vendedor vendedor = opVendedor.orElse(new Vendedor());

		Anuncio anuncio = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(280)).titulo("saída de banho")
				.vendedor(vendedor).build();
		anuncioRepository.save(anuncio);
	}

	private void criaAnuncios() {
		Vendedor kenyo = Vendedor.builder().nome("kenyo").cpf("345.678.098-90")
				.dataNascimento(LocalDate.parse("1980-02-25")).sexo('m')
				.endereco(Endereco.builder().uf(UF.GO).municipio("goiania").cep("74233-909").bairro("centro")
						.complemento("q. x lt. y").numero(123).logradouro("rua 5").build())
				.build();

		Vendedor mauri = Vendedor.builder().nome("mauri").cpf("567.678.009-90")
				.dataNascimento(LocalDate.parse("1981-02-25")).sexo('m')
				.endereco(Endereco.builder().uf(UF.RS).municipio("candido godoi").cep("74233-909").bairro("centro")
						.complemento("q. x lt. y").numero(123).logradouro("rua 5").build())
				.build();

		vendedorRepository.save(kenyo); // levando a instancia do estado transient para o estado managed
		vendedorRepository.save(mauri); // levando a instancia do estado transient para o estado managed

		Anuncio sandalia = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("sandália")
				.vendedor(kenyo).build();
		Anuncio saida = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("saida de banho")
				.vendedor(kenyo).build();

		Anuncio chinelo = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("chinelo")
				.vendedor(mauri).build();
		Anuncio creme = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("creme")
				.vendedor(mauri).build();
		Anuncio biquini = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("biquini")
				.vendedor(mauri).build();

		anuncioRepository.save(sandalia);
		anuncioRepository.save(saida);
		anuncioRepository.save(chinelo);
		anuncioRepository.save(creme);
		anuncioRepository.save(biquini);

	}

}
