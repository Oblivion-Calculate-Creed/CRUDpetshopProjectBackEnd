package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class addanimal {

    DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime ldt = LocalDateTime.now();

    public ArrayList<animal> stringarraytonewlist(ArrayList<animal> AnimalObjectList, String[]animalarray){
        String[] fixlengthdata = new String[7];
        for (int i = 0; i < fixlengthdata.length; i++) {
            fixlengthdata[i] = animalarray[i];
        }
        if (fixlengthdata[5] == null || fixlengthdata[5].equals("")){
            fixlengthdata[5] = datetimeformat.format(ldt);
        }

        AnimalObjectList.add(new animal(fixlengthdata));
        return AnimalObjectList;
    }
}