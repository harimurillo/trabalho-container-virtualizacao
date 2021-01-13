package br.com.compras.compras.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compra {
	
	@Id
	private String id;
	private String descricao;
	private LocalDate dataCompra;
	private BigDecimal valor;
	private String categoria;

}
