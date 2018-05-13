package br.com.lucas.starwarsapi.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.lucas.starwarsapi.StarwarsapiApplication;
import br.com.lucas.starwarsapi.entity.Planeta;
import br.com.lucas.starwarsapi.repository.PlanetaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = StarwarsapiApplication.class)
public class PlanetaServiceFacadeTest {
	
	@Autowired
	private PlanetaServiceFacade planetaService;
	
	@Autowired PlanetaRepository planetaRepository;
	
	@Mock 
	PlanetaRepository planetaRepositoryMock;
	@InjectMocks
	@Autowired
	private PlanetaServiceFacadeImpl planetaServiceImpl;
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void deveBuscarPlanetaPorNomeComQuantidadeAparicoesEmFilme(){
    	Planeta yavin = new Planeta();
    	planetaRepository.deleteByNome("Yavin");
    	yavin.setNome("Yavin");
    	yavin.setTerreno("Gas");
    	yavin.setId(UUID.randomUUID());
    	planetaRepository.save(yavin);
    	
    	Planeta planeta = planetaService.findByNome("Yavin");
    	assertThat(planeta, is(notNullValue()));
    	assertThat(planeta.getQuantidadeAparicoesEmFilme(), is(1));
    	
    }

    @Test
    public void deveBuscarPlanetaPorIdComQuantidadeAparicoesEmFilme(){
    	Planeta yavin = new Planeta();
    	planetaRepository.deleteByNome("Yavin");
    	yavin.setNome("Yavin");
    	yavin.setTerreno("Gas");
    	yavin.setId(UUID.randomUUID());
    	planetaRepository.save(yavin);
    	
    	Planeta planeta = planetaService.findById(yavin.getId());
    	assertThat(planeta, is(notNullValue()));
    	assertThat(planeta.getQuantidadeAparicoesEmFilme(), is(1));
    	
    }
    
    @Test 
    public void deveRetornarTodosPlanetasComQuantidadeDeAparicoesEmFilmes(){
    	List<Planeta> planetas = planetaService.findAll();
    	
    	assertThat(planetas, is(notNullValue()));
    	for(Planeta planeta : planetas){
    		assertTrue(planeta.getQuantidadeAparicoesEmFilme() > 0);
    	}
    }
    
    @Test
    public void deveCriarPlanetaComIdEQuantidadeDeAparicoesEmFilmes(){
    	Planeta yavin = new Planeta();
    	yavin.setNome("Yavin2");
    	yavin.setTerreno("Gas");
    	
    	Mockito.when(planetaRepositoryMock.save(yavin)).thenReturn(yavin);
    	planetaServiceImpl.save(yavin);
    	assertThat(yavin.getId(), is(notNullValue()));
    }
}
