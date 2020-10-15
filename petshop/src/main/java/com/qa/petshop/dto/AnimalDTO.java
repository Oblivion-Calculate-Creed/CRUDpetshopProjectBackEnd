package com.company.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AnimalDTO {
    public String GivenName;
    public String CommonName;
    public String Price;
    public String Sex;
    public String Colour;
    public String Arrival;
    public String Sell;

    public AnimalDTO(String GivenName, String CommonName, String Price, String Sex, String Colour, String Arrival, String Sell) {
        this.GivenName = GivenName;
        this.CommonName = CommonName;
        this.Price = Price;
        this.Sex = Sex;
        this.Colour = Colour;
        this.Arrival = Arrival;
        this.Sell = Sell;
    }
}
