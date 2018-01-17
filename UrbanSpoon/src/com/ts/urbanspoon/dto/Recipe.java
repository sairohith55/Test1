package com.ts.urbanspoon.dto;

public class Recipe {
private int id;
private String name;
private String imageName;
private String description;
private int isVeg;
private float price;


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


public Recipe() {
}


public String getImageName() {
	return imageName;
}


public void setImageName(String imageName) {
	this.imageName = imageName;
}

public int getId() {
	return id;
}

public void setId(int id) {
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

public int getIsVeg() {
	return isVeg;
}

public void setIsVeg(int isVeg) {
	this.isVeg = isVeg;
}

@Override
public String toString() {
	return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", is veg = "+isVeg+" ]";
}



	 
}
