package br.com.compras.compras.service;

import java.util.List;

import br.com.compras.compras.model.Compra;

public interface CompraService {
	
    List<Compra> findAll();

    Compra findById(String id);

    Compra create(Compra compra);

    Compra update(Compra compra);

    void delete(Compra compra);

}
