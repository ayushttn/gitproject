package com.Ayush.SpringAssignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Audi implements Honk{
    public String Honking(){
        return "Audi Honking";
    }
}
