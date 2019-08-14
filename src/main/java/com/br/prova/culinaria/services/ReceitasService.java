package com.br.prova.culinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.prova.culinaria.models.Receitas;
import com.br.prova.culinaria.repositories.ReceitasRepository;

@Service
public class ReceitasService {
	
	@Autowired
	private ReceitasRepository receitasRepository;

	public Receitas criarReceita(Receitas receitas) {
		receitasRepository.save(receitas);
		return receitas;
	}

	public Iterable<Receitas> listaDeReceitas() {
		return receitasRepository.findAll();

	}

	public Receitas buscarReceita(int id) {
		Receitas receita;

		try {
			receita = receitasRepository.findById(id).get();
		} catch (Exception e) {
			receita = null;
		}
		return receita;

	}

	public Receitas atualizarReceitas(int id) {
		Receitas receita;
		
		try {
			receita = receitasRepository.findById(id).get();
		} catch (Exception e) {
			receita = null;
		}
		return receita;

	}
	
	public void apagarReceita(int id) {
		receitasRepository.deleteById(id);
	}
}

