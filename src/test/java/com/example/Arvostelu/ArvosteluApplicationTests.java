package com.example.Arvostelu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.Arvostelu.web.ArvosteluController;

@SpringBootTest
class ArvosteluApplicationTests {

	@Autowired 
	private ArvosteluController controller;
	
	@Test 
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		}
	}