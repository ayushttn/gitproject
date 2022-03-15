package com.springdatajpa2.entities;

import com.springdatajpa2.entities.Employee;import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("rw")
public class RetiredWorkers extends Worker{
    private double pension;

    public double getPension() {
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }
}
