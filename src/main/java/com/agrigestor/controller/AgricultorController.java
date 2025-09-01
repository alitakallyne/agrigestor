package com.agrigestor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrigestor.model.Agricultor;
import com.agrigestor.service.AgricultorService;

@RestController
@RequestMapping("/agricultor")
public class AgricultorController {

	@Autowired
	private  AgricultorService service;
	
	 @GetMapping
	    public List<Agricultor> listarTodos() {
	        return service.listarTodos();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Agricultor> buscarPorId(@PathVariable Long id) {
	        return service.buscarPorId(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Agricultor> salvar(@RequestBody Agricultor agricultor) {
	        return ResponseEntity.ok(service.salvar(agricultor));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Agricultor> atualizar(@PathVariable Long id, @RequestBody Agricultor agricultor) {
	        return ResponseEntity.ok(service.atualizar(id, agricultor));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	        service.deletar(id);
	        return ResponseEntity.noContent().build();
	    }
}
