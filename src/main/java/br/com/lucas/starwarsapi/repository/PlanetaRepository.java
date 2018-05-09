package br.com.lucas.starwarsapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.starwarsapi.entity.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String>{

	Planeta findByNome(String nome);
	
	Planeta findById(UUID id);
	
	void deleteById(UUID id);
	
	Planeta save(Planeta planeta);
	
	List<Planeta> findAll();
	
}
