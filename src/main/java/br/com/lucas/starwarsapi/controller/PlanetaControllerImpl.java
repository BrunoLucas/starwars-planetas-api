package br.com.lucas.starwarsapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.starwarsapi.dto.PlanetaLista;
//TODO criar web service rest chamando repository e webservice
import br.com.lucas.starwarsapi.entity.Planeta;
import br.com.lucas.starwarsapi.service.PlanetaServiceFacade;

@RestController
public class PlanetaControllerImpl implements PlanetaController{

	
	@Autowired private PlanetaServiceFacade planetaServiceFacade;
	
	@RequestMapping("/findByNome")
	public ResponseEntity<Planeta> findByNome(@RequestParam(value="nome") String nome) {
		return ResponseEntity.ok(planetaServiceFacade.findByNome(nome));
	}

	@RequestMapping("/findById")
	public ResponseEntity<Planeta> findById(@RequestParam(value="id") UUID id) {
		return ResponseEntity.ok(planetaServiceFacade.findById(id));
	}
	@DeleteMapping("/deleteById")
	public ResponseEntity<Boolean> deleteById(@RequestParam(value="id") UUID id) {
		 boolean delete = planetaServiceFacade.deleteById(id);
		 if(delete == true){
			 return ResponseEntity.ok().build();
		 }else{
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
	}
	@DeleteMapping("/deleteByNome/{nome}")
	public ResponseEntity<Boolean> deleteByNome(@PathVariable(value="nome")String nome) {
		 boolean delete = planetaServiceFacade.deleteByNome(nome);
		 if(delete == true){
			 return ResponseEntity.ok().build();
		 }else{
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
	}
	
	@PostMapping("/save")
	public ResponseEntity<Planeta> save(@RequestBody Planeta planeta) {
		return ResponseEntity.ok(planetaServiceFacade.save(planeta));
	}
	@RequestMapping("/findAll")
	public ResponseEntity<PlanetaLista> findAll() {
		List<Planeta> planetas = planetaServiceFacade.findAll();
		PlanetaLista planetasLista = new PlanetaLista();
		for(Planeta planeta : planetas){
			planetasLista.getPlanetas().add(planeta);
		}
		return ResponseEntity.ok(planetasLista);
	}

	
}
