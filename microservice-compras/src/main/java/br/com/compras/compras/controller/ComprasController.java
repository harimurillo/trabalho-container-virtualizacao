package br.com.compras.compras.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.compras.compras.model.Compra;
import br.com.compras.compras.service.CompraService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("compras")
public class ComprasController {
	
	private final CompraService service;
	
    public ComprasController(CompraService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Compra>> getAllMensagens() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Compra> getMensagem(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra create(@RequestBody Compra compra) {
        return service.create(compra);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        Compra compra = new Compra();
        compra.setId(id);

        service.delete(compra);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Compra update(@RequestBody Compra compra, @PathVariable String id) {
        Compra updateCompra = service.findById(id);

        updateCompra.setCategoria(compra.getCategoria() != null ? compra.getCategoria() : updateCompra.getCategoria());
        updateCompra.setDataCompra(compra.getDataCompra() != null ? compra.getDataCompra() : updateCompra.getDataCompra());
        updateCompra.setDescricao(compra.getDescricao() != null ? compra.getDescricao() : updateCompra.getDescricao());
        updateCompra.setValor(compra.getValor() != null ? compra.getValor() : updateCompra.getValor());

        return service.update(updateCompra);
    }

}
