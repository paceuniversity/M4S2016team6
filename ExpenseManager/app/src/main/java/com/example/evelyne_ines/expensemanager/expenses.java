package com.example.evelyne_ines.expensemanager;

import java.util.Date;

/**
 * Created by evelyne-ines on 07/08/16.
 */
public class expenses {
    int Id;
    String article;
    float price;
    String date;

    //constructors
    public expenses() {
    }

    public expenses(String article, float price, String date) {
        this.article = article;
        this.price = price;
        this.date = date;
    }
    //Getters and Setters

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
