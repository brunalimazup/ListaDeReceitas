package com.br.prova.culinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.prova.culinaria.models.Receitas;
import com.br.prova.culinaria.services.ReceitasService;

@RestController
@RequestMapping("/receitas")
public class ReceitasController {

	@Autowired
	private ReceitasService receitasService;

	@PostMapping
	public ResponseEntity<?> criarReceita(@RequestBody Receitas receitas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(receitasService.criarReceita(receitas));
	}

	@GetMapping
	public ResponseEntity<?> listaDeReceitas() {
		return ResponseEntity.ok(receitasService.listaDeReceitas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarReceita(@PathVariable int id) {
		Receitas receita = receitasService.buscarReceita(id);
		if (receita == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(receita);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarReceita(@PathVariable int id) {
		Receitas receita = receitasService.atualizarReceitas(id);
		if (receita == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(receita);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagarReceita(@PathVariable int id) {
		try {
			receitasService.apagarReceita(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
