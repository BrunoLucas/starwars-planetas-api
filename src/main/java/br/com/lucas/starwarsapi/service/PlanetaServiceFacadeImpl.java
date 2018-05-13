package br.com.lucas.starwarsapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.starwarsapi.dto.PlanetaAPIDTO;
import br.com.lucas.starwarsapi.entity.Planeta;
import br.com.lucas.starwarsapi.repository.PlanetaRepository;
import br.com.lucas.starwarsapi.webservice.PlanetaWebService;

@Service
public class PlanetaServiceFacadeImpl implements PlanetaServiceFacade{

	@Autowired
	private PlanetaRepository planetaRepository;
	@Autowired
	private PlanetaWebService planetaWebService;
	
	public Planeta findByNome(String nome) {
		Planeta planeta = planetaRepository.findByNome(nome);
		if(planeta.getQuantidadeAparicoesEmFilme() == null){
			planeta.setQuantidadeAparicoesEmFilme(quantidadeAparicoesEmFilmes(nome));
		}
		return planeta;
	}

	public Planeta findById(UUID id) {
		Planeta planeta = planetaRepository.findById(id);
		if(planeta.getQuantidadeAparicoesEmFilme() == null){
			planeta.setQuantidadeAparicoesEmFilme(quantidadeAparicoesEmFilmes(planeta.getNome()));
		}
		return planeta;
	}
	
	public void deleteById(UUID id){
		planetaRepository.deleteById(id);
	}
	
	public List<Planeta> findAll() {
		 List<Planeta> planetas = planetaRepository.findAll();
		 
		 for(Planeta planeta : planetas){
			 if(planeta.getQuantidadeAparicoesEmFilme() == null){
				 planeta.setQuantidadeAparicoesEmFilme(quantidadeAparicoesEmFilmes(planeta.getNome()));
			 }
		 }
		 return planetas;
	}
	
	private Integer quantidadeAparicoesEmFilmes(String nome){
		Integer quantidade = 0;
		PlanetaAPIDTO planetaAPI = planetaWebService.obterPlanetaPor(nome);
		if(planetaAPI != null && planetaAPI.getFilms() != null){
			quantidade = planetaAPI.getFilms().size();
		}
		return quantidade;
	}

	public void deleteByNome(String nome) {
		planetaRepository.deleteByNome(nome);
	}

	public Planeta save(Planeta planeta) {
		planeta.setQuantidadeAparicoesEmFilme(quantidadeAparicoesEmFilmes(planeta.getNome()));
		return planetaRepository.save(planeta);
	}

	

}
