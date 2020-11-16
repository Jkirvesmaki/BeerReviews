package com.example.Arvostelu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long categoryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Arvostelu> arvostelut;
	
	public Category() {
	
}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

}
	

