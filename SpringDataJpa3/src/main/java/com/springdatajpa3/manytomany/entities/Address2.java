package com.springdatajpa3.manytomany.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address2 {

    private String streetNumber;
    private String location;
    private String state;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
