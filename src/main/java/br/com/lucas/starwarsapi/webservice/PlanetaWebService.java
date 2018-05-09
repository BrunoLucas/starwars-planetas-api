package br.com.lucas.starwarsapi.webservice;

import br.com.lucas.starwarsapi.dto.PlanetaAPIDTO;

public interface PlanetaWebService {

	public PlanetaAPIDTO obterPlanetaPor(String nome);
}
