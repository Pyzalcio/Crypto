package com.example.crypto.model;

import javax.persistence.*;

@Entity
@Table(name = "exchange")
public class Exchange
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fromCoin;
    private String toCoin;
    private double amount;
    private double result;

    Exchange()
    {

    }

    public String getFromCoin() {
        return fromCoin;
    }

    public String getToCoin() {
        return toCoin;
    }

    public double getAmount() {
        return amount;
    }

    public double getResult(){
        return result;
    }

    public void setFromCoin(String fromCoin) {
        this.fromCoin = fromCoin;
    }

    public void setToCoin(String toCoin) {
        this.toCoin = toCoin;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
