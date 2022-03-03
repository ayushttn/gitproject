package com.Ayush.SpringAssignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Audi implements Honk{
    public String Honking(){
        return "Audi Honking";
    }
}
