package com.company.function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class sellanimal {

    DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime ldt = LocalDateTime.now();

    public ArrayList<animal> checkselectanimalsell (ArrayList<animal> AnimalObjectList, int rownumber){
        if (AnimalObjectList.get(rownumber).getSell() == null || AnimalObjectList.get(rownumber).getSell().equals("")){
            AnimalObjectList.set(rownumber, new animal(
                    AnimalObjectList.get(rownumber).getGivenName(),
                    AnimalObjectList.get(rownumber).getCommonName(),
                    AnimalObjectList.get(rownumber).getPrice(),
                    AnimalObjectList.get(rownumber).getSex(),
                    AnimalObjectList.get(rownumber).getColour(),
                    AnimalObjectList.get(rownumber).getArrival(),
                    datetimeformat.format(ldt)
            ));
        }
        return AnimalObjectList;
    }
}
