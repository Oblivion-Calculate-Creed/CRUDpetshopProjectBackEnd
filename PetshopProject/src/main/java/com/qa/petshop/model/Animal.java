package com.qa.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {
    public String GivenName;
    public String CommonName;
    public String Price;
    public String Sex;
    public String Colour;
    public String Arrival;
    public String Sell;

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

	public Animal(String GivenName, String CommonName, String Price, String Sex, String Colour, String Arrival, String Sell) {
        this.GivenName = GivenName;
        this.CommonName = CommonName;
        this.Price = Price;
        this.Sex = Sex;
        this.Colour = Colour;
        this.Arrival = Arrival;
        this.Sell = Sell;
    }

    public Animal(String[] info) {
        this(info[0], info[1], info[2], info[3], info[4], info[5], info[6]);
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String input) {
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

    public String getSell() {
        return Sell;
    }

    public void setSell(String input) {
        this.Sell = input;
    }
}
