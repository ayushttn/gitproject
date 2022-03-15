package com.springdatajpa2.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="codorder")
public class CodOrders extends Order {
    private int codOrderId;

    public int getCodOrderId() {
        return codOrderId;
    }

    public void setCodOrderId(int codOrderId) {
        this.codOrderId = codOrderId;
    }
}
