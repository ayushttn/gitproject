package com.Ayush.SpringAssignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class BMW implements Honk{
    public String Honking(){
        return "BMW Honking";
    }
}
