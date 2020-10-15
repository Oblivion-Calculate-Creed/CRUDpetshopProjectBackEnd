package com.qa.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {
    public String givenName;
    public String commonName;
    public String type;
    public int price;
    public String sex;
    public String colour;
    public String arrival;

    @Id
    @GeneratedValue
    private Long Id;

    public Animal() {
    }
    
    public Animal(String GivenName, String CommonName, String Type, int Price, String Sex, String Colour, String Arrival) {
        this.givenName = GivenName;
        this.commonName = CommonName;
        this.type = Type;
        this.price = Price;
        this.sex = Sex;
        this.colour = Colour;
        this.arrival = Arrival;

    }

	public Animal(String[] info) {
        this();
    }

	public String getArrival() {
        return arrival;
    }

    public String getColour() {
        return colour;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getGivenName() {
        return givenName;
    }

    public Long getId() {
		return Id;
	}

    public int getPrice() {
        return price;
    }

    public String getSex() {
        return sex;
    }

    public String getType() {
        return type;
    }

    public void setArrival(String input) {
        this.arrival = input;
    }

    public void setColour(String input) {
        this.colour = input;
    }

    public void setCommonName(String input) {
        this.commonName = input;
    }

    public void setGivenName(String input) {
        this.givenName = input;
    }

    public void setId(Long id) {
		Id = id;
	}

    public void setPrice(int input) {
        this.price = input;
    }

    public void setSex(String input) {
        this.sex = input;
    }

    public void setType(String input) {
        this.type = input;
    }

}
