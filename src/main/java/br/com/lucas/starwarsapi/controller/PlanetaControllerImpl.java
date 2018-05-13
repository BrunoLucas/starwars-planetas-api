package br.com.lucas.starwarsapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//TODO criar web service rest chamando repository e webservice
import br.com.lucas.starwarsapi.entity.Planeta;
import br.com.lucas.starwarsapi.service.PlanetaServiceFacade;

@RestController
public class PlanetaControllerImpl implements PlanetaController{

	
	@Autowired private PlanetaServiceFacade planetaServiceFacade;
	
	@RequestMapping("/findByNome")
	public Planeta findByNome(@RequestParam(value="nome") String nome) {
		return planetaServiceFacade.findByNome(nome);
	}

	@RequestMapping("/findById")
	public Planeta findById(@RequestParam(value="id") UUID id) {
		return planetaServiceFacade.findById(id);
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable(value="id") UUID id) {
		 planetaServiceFacade.deleteById(id);
	}
	@DeleteMapping("/deleteByNome/{nome}")
	public void deleteByNome(@PathVariable(value="nome")String nome) {
		planetaServiceFacade.deleteByNome(nome);
	}
	
	@PostMapping("/planeta")
	public Planeta save(@RequestBody Planeta planeta) {
		// TODO Auto-generated method stub
		return planetaServiceFacade.save(planeta);
	}
	@RequestMapping("/findAll")
	public List<Planeta> findAll() {
		return planetaServiceFacade.findAll();
	}

	
}
