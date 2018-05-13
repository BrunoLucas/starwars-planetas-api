package br.com.lucas.starwarsapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.starwarsapi.entity.Planeta;

public class PlanetaLista implements Serializable{

	private static final long serialVersionUID = -6117971299221433315L;

	private List<Planeta> planetas;
	public PlanetaLista() {
		this.planetas = new ArrayList<Planeta>();
	}
	
	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}
	
	
}
