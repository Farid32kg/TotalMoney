package com.example.back_end.model;


import java.time.LocalDate;

public class TotalAll {



    private double rabite;
   private double kapital;
   private double cash;
   private String notes;
   private String date;


    public double getRabite() {
        return rabite;
    }

    public void setRabite(double rabite) {
        this.rabite = rabite;
    }

    public double getKapital() {
        return kapital;
    }

    public void setKapital(double kapital) {
        this.kapital = kapital;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
