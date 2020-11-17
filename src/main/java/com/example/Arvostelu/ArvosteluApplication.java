package com.example.Arvostelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.Arvostelu.model.Arvostelu;
import com.example.Arvostelu.model.ArvosteluRepository;
import com.example.Arvostelu.model.Category;
import com.example.Arvostelu.model.CategoryRepository;
import com.example.Arvostelu.model.User;
import com.example.Arvostelu.model.UserRepository;

@SpringBootApplication
public class ArvosteluApplication {


		private static final Logger log = LoggerFactory.getLogger(ArvosteluApplication.class);
		
		public static void main(String[] args) {
			SpringApplication.run(ArvosteluApplication.class, args);
		}
		@Bean
		public CommandLineRunner arvosteluDemo(ArvosteluRepository arepository, CategoryRepository crepository,UserRepository urepository) {
			return (args) -> {
				
	
				log.info("saving a couple reviews");
				Category category1 = new Category("Lager");
				Category category2 = new Category("Pilsner");
				Category category3 = new Category("IPA");
				Category category4 = new Category("Ale");
				crepository.deleteAll();
				crepository.save(category1);
				crepository.save(category2);
				crepository.save(category3);
				crepository.save(category4);
				log.info("fetch all reviews");
				User user1 = new User(null, "joonas2", "$2y$12$.yqQrFCmU53msFJLZrSvF.CpbrsUr612Ac3vFblyw.tMW.VwrXsKS", "joonas.kirvesmaki@gmail.com", "ADMIN");
				User user2 = new User(null, "joonas1", "$2y$12$.yqQrFCmU53msFJLZrSvF.CpbrsUr612Ac3vFblyw.tMW.VwrXsKS", "joonas.kirvesmaki@gmail.com", "user");
				urepository.deleteAll();
				urepository.save(user1);
		        urepository.save(user2);
				for (Arvostelu arvostelu : arepository.findAll()) {
					log.info(arvostelu.toString());
				}
	
			};
		}
		
	}