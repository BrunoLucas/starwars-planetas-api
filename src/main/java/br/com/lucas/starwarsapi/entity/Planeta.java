package br.com.lucas.starwarsapi.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="planeta")
public class Planeta {

	@Id
	private UUID id;

	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer quantidadeAparicoesEmFilme;


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantidadeAparicoesEmFilme() {
		return quantidadeAparicoesEmFilme;
	}

	public void setQuantidadeAparicoesEmFilme(Integer quantidadeAparicoesEmFilme) {
		this.quantidadeAparicoesEmFilme = quantidadeAparicoesEmFilme;
	}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nome=" + nome + ", clima=" + clima
				+ ", terreno=" + terreno + ", quantidadeAparicoesEmFilme="
				+ quantidadeAparicoesEmFilme + "]";
	}

	
}
