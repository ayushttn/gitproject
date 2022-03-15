package com.springdatajpa2.entities;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("ch")
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumbers) {
        this.checknumber = checknumbers;
    }
}
