package br.com.meli.storage.es.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonDeserialize(using = LocalDateDeserializer.class)  
//@JsonSerialize(using = LocalDateSerializer.class)
@Document(indexName = "ad")
public class Ad {

	@Id
	private String id;
	private String code;
	private String title;
	
	private int stock;
	private BigDecimal price;
	@JsonSerialize
	@JsonDeserialize
	private List<String> tag;
	
	//@Field(type = FieldType.Date)
	//@Field(type = FieldType.Date, format = DateFormat.)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")  
//	private LocalDate date;
	
}
