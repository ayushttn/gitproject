package com.springdatajpa2.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="onlineorder")
public class OnlineOrder extends Order{
    private int onlineOrderId;

    public int getOnlineOrderId() {
        return onlineOrderId;
    }

    public void setOnlineOrderId(int onlineOrderId) {
        this.onlineOrderId = onlineOrderId;
    }
}
