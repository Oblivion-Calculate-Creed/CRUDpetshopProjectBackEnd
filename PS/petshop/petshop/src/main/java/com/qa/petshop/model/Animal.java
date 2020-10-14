package com.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class animal {
    public String GivenName;
    public String CommonName;
    public String Price;
    public String Sex;
    public String Colour;
    public String Arrival;
    public String Sell;

    public animal() {
    }

    public animal(String GivenName, String CommonName, String Price, String Sex, String Colour, String Arrival, String Sell) {
        this.GivenName = GivenName;
        this.CommonName = CommonName;
        this.Price = Price;
        this.Sex = Sex;
        this.Colour = Colour;
        this.Arrival = Arrival;
        this.Sell = Sell;

    @Id
    @GenerateValue
    public Long getId() {
            return id;
        }
    }

    public animal(String[] info) {
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
