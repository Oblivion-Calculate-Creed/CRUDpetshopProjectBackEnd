package com.company.functions;

import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.AnimalDTO;
import com.company.dto.Animal;
import com.company.dto.PetshopRepo;

@Service
public class Addanimal {

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