package br.com.lucas.starwarsapi.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.UUID;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void deveSalvarPlaneta(){
    	
    	Planeta planeta = new Planeta();
    	planeta.setNome("Tatooine");
    	planeta.setTerreno("Desert");
    	planeta.setId(UUID.randomUUID());
    	Planeta planetaSalvo = planetaRepository.save(planeta);
    	assertThat(planetaSalvo, is(notNullValue()));
    	assertThat(planetaSalvo.getId(), IsEqual.equalTo(planeta.getId()));
    	
    }
    
    @Test
    public void deveListarTodosPlanetas(){
    	List<Planeta> planetas = planetaRepository.findAll();
    	assertThat(planetas, is(notNullValue()));
    }
    
    @Test
    public void deveBuscarPlanetaPorNome(){
    	
    	salvarPlanetaParaTeste();
    	
    	Planeta yavin = planetaRepository.findByNome("Yavin");
    	assertThat(yavin, is(notNullValue()));
    	assertThat(yavin.getNome(), is("Yavin"));
    	assertThat(yavin.getTerreno(), is("Gas"));
    }

    @Test
    public void deveBuscarPlanetaPorId(){
    	Planeta planeta = salvarPlanetaParaTeste();
    	Planeta yavin = planetaRepository.findById(planeta.getId());
    	assertThat(yavin, is(notNullValue()));
    	assertThat(yavin.getId(), is(planeta.getId()));
    
    }
    
    @Test
    public void deveRemoverPlaneta(){
    	Planeta planeta = salvarPlanetaParaTeste();
    	planetaRepository.delete(planeta);
    	Planeta yavin = planetaRepository.findById(planeta.getId());
    	assertThat(yavin, is(nullValue()));
    
    }
    
    public Planeta salvarPlanetaParaTeste(){
    	Planeta planeta = new Planeta();
    	planetaRepository.deleteByNome("Yavin");
    	planeta.setNome("Yavin");
    	planeta.setTerreno("Gas");
    	planeta.setId(UUID.randomUUID());
    	planetaRepository.save(planeta);
    	return planeta;
    }
    
}
