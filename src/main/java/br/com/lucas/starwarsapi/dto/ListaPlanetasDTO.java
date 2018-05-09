package br.com.lucas.starwarsapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaPlanetasDTO {

	private Integer count;
	
	private String next;
	
	private String previous;
	
	private List<PlanetaAPIDTO> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<PlanetaAPIDTO> getResults() {
		return results;
	}

	public void setResults(List<PlanetaAPIDTO> results) {
		this.results = results;
	}
	
	

}
