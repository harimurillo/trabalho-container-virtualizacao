package br.com.compras.compras.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.compras.compras.model.Compra;

public interface CompraRepository extends MongoRepository<Compra, String> {

}
