package br.com.lucas.starwarsapi.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.lucas.starwarsapi.StarwarsapiApplication;
import br.com.lucas.starwarsapi.dto.PlanetaAPIDTO;
import br.com.lucas.starwarsapi.webservice.PlanetaWebService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = StarwarsapiApplication.class)
public class PlanetasWebServiceTest {

	@Autowired
	private PlanetaWebService planetaWebService;
	
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void deveObterPlanetaPorNome(){
    	String nome = "Tatooine";
    	PlanetaAPIDTO planetaRetornado = planetaWebService.obterPlanetaPor(nome);
    	assertThat(planetaRetornado, is(notNullValue()));
    	assertThat(planetaRetornado.getName(), IsEqual.equalTo(nome));
    }
    
    @Test
    public void deveRetornarNuloAoBuscarPlanetaInexistente(){
    	String nome = "Estrela";
    	PlanetaAPIDTO planetaRetornado = planetaWebService.obterPlanetaPor(nome);
    	assertThat(planetaRetornado, is(nullValue()));
    }
    @Test
    public void deveRetornarNuloAoBuscarPlanetaSemPassarNome(){
    	PlanetaAPIDTO planetaRetornado = planetaWebService.obterPlanetaPor(null);
    	assertThat(planetaRetornado, is(nullValue()));
    }
}
