package br.com.lucas.starwarsapi.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import br.com.lucas.starwarsapi.dto.PlanetaLista;
import br.com.lucas.starwarsapi.entity.Planeta;

public interface PlanetaController {

	public ResponseEntity<Planeta> findByNome(String nome);

	public ResponseEntity<Planeta> findById(UUID id);

	public ResponseEntity<Boolean> deleteById(UUID id);

	public ResponseEntity<Boolean> deleteByNome(String nome);

	public ResponseEntity<Planeta> save(Planeta planeta);

	public ResponseEntity<PlanetaLista> findAll();
}
