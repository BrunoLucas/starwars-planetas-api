package br.com.lucas.starwarsapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucas.starwarsapi.entity.Planeta;

public interface PlanetaServiceFacade {

	public Planeta findByNome(String nome);
	
	public Planeta findById(UUID id);
	
	public boolean deleteById(UUID id);
	
	public List<Planeta> findAll();

	public boolean deleteByNome(String nome);

	public Planeta save(Planeta planeta);
}
