package com.example.Arvostelu;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Arvostelu.model.ArvosteluRepository;
import com.example.Arvostelu.model.Arvostelu;

@RunWith(SpringRunner.class)
@DataJpaTest


public class ArvosteluJPAtest {
	@Autowired
	private ArvosteluRepository repository;
	
	@Test
	public void findByNameShouldReturnName(){
		List<Arvostelu> arvostelut=repository.findByName("Karhu");
		assertThat(arvostelut).hasSize(1);
		assertThat(arvostelut.get(0).getName()).isEqualTo("Karhu");
	
}

	@Test
	

	public void createNewArvostelu(){
		List<Arvostelu> arvostelut = repository.findByName("Karhu");
		assertThat(arvostelut).hasSize(1);
		assertThat(arvostelut.get(0).getName()).isEqualTo("Karhu");
	}
}