package br.com.lucas.starwarsapi.webservice;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.lucas.starwarsapi.dto.ListaPlanetasDTO;
import br.com.lucas.starwarsapi.dto.PlanetaAPIDTO;


@Service
public class PlanetaWebServiceImpl implements PlanetaWebService{

	public PlanetaAPIDTO obterPlanetaPor(String nome) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://swapi.co/api/planets/?search=" + nome;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Content-Encoding", "gzip");
		headers.add("User-Agent", "cheese");

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<ListaPlanetasDTO> dtoBaseApi = restTemplate.exchange(url, HttpMethod.GET, entity,
				ListaPlanetasDTO.class);

		if (dtoBaseApi.getBody() != null) {
			if (dtoBaseApi.getBody().getResults() != null) {
				if(dtoBaseApi.getBody().getResults().size() > 0) {
					return dtoBaseApi.getBody().getResults().get(0);
				}
			}
		}
		return null;
	}

}
