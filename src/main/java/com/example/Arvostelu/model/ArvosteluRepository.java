package com.example.Arvostelu.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArvosteluRepository extends CrudRepository<Arvostelu, Long> {
	List <Arvostelu> findByName (String name);
	List <Arvostelu> findIdByName (String name);
}
