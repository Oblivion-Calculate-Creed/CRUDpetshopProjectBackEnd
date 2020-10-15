package com.qa.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {
    public String GivenName;
    public String CommonName;
    public String Type;
    public int Price;
    public String Sex;
    public String Colour;
    public String Arrival;

    public Animal() {
    }

    @Id
    @GeneratedValue
    private Long Id;
    
    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Animal(String GivenName, String CommonName, String Type, int Price, String Sex, String Colour, String Arrival) {
        this.GivenName = GivenName;
        this.CommonName = CommonName;
        this.Type = Type;
        this.Price = Price;
        this.Sex = Sex;
        this.Colour = Colour;
        this.Arrival = Arrival;

    }

    public Animal(String[] info) {
        this();
    }

    public String getGivenName() {
        return GivenName;
    }

    public void setGivenName(String input) {
        this.GivenName = input;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setCommonName(String input) {
        this.CommonName = input;
    }

    public String getType() {
        return Type;
    }

    public void setType(String input) {
        this.Type = input;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int input) {
        this.Price = input;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String input) {
        this.Sex = input;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String input) {
        this.Colour = input;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String input) {
        this.Arrival = input;
    }

}
