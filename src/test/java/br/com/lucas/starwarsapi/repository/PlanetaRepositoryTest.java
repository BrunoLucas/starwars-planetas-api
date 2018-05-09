package br.com.lucas.starwarsapi.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.UUID;

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
import br.com.lucas.starwarsapi.entity.Planeta;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = StarwarsapiApplication.class)
public class PlanetaRepositoryTest {

	@Autowired
	private PlanetaRepository planetaRepository;
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
    	
    	Planeta planeta = new Planeta();
    	planeta.setNome("Tatooine");
    	planeta.setTerreno("Desert");
    	planeta.setId(UUID.randomUUID());
    	Planeta planetaSalvo = planetaRepository.save(planeta);
    	assertThat(planetaSalvo, is(notNullValue()));
    	assertThat(planetaSalvo.getId(), IsEqual.equalTo(planeta.getId()));
    }
}
