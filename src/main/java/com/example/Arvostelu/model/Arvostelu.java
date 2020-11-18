package com.example.Arvostelu.model;

import javax.persistence.*;

import net.minidev.json.annotate.JsonIgnore;

//tehdään arvostelu luokka

@Entity
public class Arvostelu {
@Id
@Column(name = "id")
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private String description;
private Double score;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "categoryId")
private Category category;

public Arvostelu() {
	
}



public Arvostelu(String name, String description, Double arvosana, Category category) {
	super();

	this.name = name;
	this.description = description;
	this.score = arvosana;
	this.category = category;
}


public Long getId() {

	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getScore() {
	return score;
}
public void setScore(Double score) {
	this.score = score;
}

public Category getCategory() {
    return category;
}

public void setCategory(Category category) {
    this.category = category;
}



@Override
public String toString() {
	if (this.category != null)
	return "Arvostelu [id=" + id + ", name=" + name + ", description=" + description + ", score=" + score + ", category=" + this.getCategory() + "]";
	else
		return "Arvostelu [id=" + id + ", name=" + name + ", description=" + description + ", score=" + score + "]";
}




}
