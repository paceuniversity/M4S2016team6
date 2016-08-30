package com.example.evelyne_ines.expensemanager;

import java.util.Date;

/**
 * Created by evelyne-ines on 07/08/16.
 */
public class earnings {
    int Id;
    float amount;
    String date;

    //Constructors

    public earnings() {
    }

    public earnings(float amount, String date) {
        this.amount = amount;
        this.date = date;
    }
    //Getters and Setters

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
