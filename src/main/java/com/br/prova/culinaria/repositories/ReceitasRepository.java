package com.br.prova.culinaria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.prova.culinaria.models.Receitas;

@Repository
public interface ReceitasRepository extends CrudRepository<Receitas, Integer> {

}
