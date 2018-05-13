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
		Planeta planeta = planetaServiceFacade.findByNome(nome);
		if(planeta != null){
			return ResponseEntity.ok(planeta);
		}else{
			return ResponseEntity.badRequest().header("erro", "Planeta não encontrado!").build();
		}
	}

	@RequestMapping("/findById")
	public ResponseEntity<Planeta> findById(@RequestParam(value="id") UUID id) {
		Planeta planeta =  planetaServiceFacade.findById(id);
		if(planeta != null){
			return ResponseEntity.ok(planeta);
		}else{
			return ResponseEntity.badRequest().header("erro", "Planeta não encontrado!").build();
		}
	}
	@DeleteMapping("/deleteById")
	public ResponseEntity<Boolean> deleteById(@RequestParam(value="id") UUID id) {
		 boolean delete = planetaServiceFacade.deleteById(id);
		 if(delete == true){
			 return ResponseEntity.ok().build();
		 }else{
			 return ResponseEntity.badRequest().header("erro", "Não foi possível deletar!").build();
		 }
	}
	@DeleteMapping("/deleteByNome/{nome}")
	public ResponseEntity<Boolean> deleteByNome(@PathVariable(value="nome")String nome) {
		 boolean delete = planetaServiceFacade.deleteByNome(nome);
		 if(delete == true){
			 return ResponseEntity.ok().build();
		 }else{
			 return ResponseEntity.badRequest().header("erro", "Não foi possível deletar!").build();
		 }
	}
	
	@PostMapping("/save")
	public ResponseEntity<Planeta> save(@RequestBody Planeta planeta) {
		Planeta planetaSalvo = planetaServiceFacade.save(planeta);
		if(planetaSalvo != null){
			return ResponseEntity.ok(planetaSalvo);
		}else{
			 return ResponseEntity.status(500).header("erro", "Não foi possível deletar!").build();

		}
	}
	@RequestMapping("/findAll")
	public ResponseEntity<PlanetaLista> findAll() {
		List<Planeta> planetas = planetaServiceFacade.findAll();
		PlanetaLista planetasLista = new PlanetaLista();
		for(Planeta planeta : planetas){
			planetasLista.getPlanetas().add(planeta);
		}
		if(!planetasLista.getPlanetas().isEmpty()){
			return ResponseEntity.ok(planetasLista);
		}else{
			return ResponseEntity.status(500).header("erro", "Não foram encontrados planetas!").build();
		}
	}

	
}
