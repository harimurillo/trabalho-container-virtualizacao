package br.com.compras.compras.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.compras.compras.model.Compra;
import br.com.compras.compras.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService{
	
	private final CompraRepository repository;
	
	public CompraServiceImpl(CompraRepository repository) {
		this.repository = repository;
	}

	public List<Compra> findAll() {
		return repository.findAll();
	}

	public Compra findById(String id) {
		return getCompraById(id);
	}

	public Compra create(Compra compra) {
		return repository.save(compra);
	}

	public Compra update(Compra compra) {
		return repository.save(compra);
	}

	public void delete(Compra compra) {
		repository.delete(compra);
	}

    private Compra getCompraById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
	

}
