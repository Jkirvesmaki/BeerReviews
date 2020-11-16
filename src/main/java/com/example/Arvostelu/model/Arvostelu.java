package com.example.Arvostelu.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import net.minidev.json.annotate.JsonIgnore;


@Entity
public class Arvostelu {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String name;
private String description;
private double score;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "categoryId")
private Category category;

public Arvostelu() {
	
}



public Arvostelu(String name, String description, double arvosana, Category category) {
	super();

	this.name = name;
	this.description = description;
	this.score = arvosana;
	this.category = category;
}


public long getId() {

	return id;
}
public void setId(long id) {
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
public double getScore() {
	return score;
}
public void setScore(double score) {
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
