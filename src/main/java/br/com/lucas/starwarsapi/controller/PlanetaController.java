package br.com.lucas.starwarsapi.controller;

import java.util.List;
import java.util.UUID;

import br.com.lucas.starwarsapi.entity.Planeta;

public interface PlanetaController {

	public Planeta findByNome(String nome);

	public Planeta findById(UUID id);

	public void deleteById(UUID id);

	public void deleteByNome(String nome);

	public Planeta save(Planeta planeta);

	public List<Planeta> findAll();
}
