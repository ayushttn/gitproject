package com.springdatajpa2.entities;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("cc")
@Table(name="card")
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
