package com.bollywood.dreacas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculationData")
public class CalculationData {

    @PrimaryKey(autoGenerate = true)
    private final int id;
    private int balance;
    private int rate;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public CalculationData(int id, int balance, int rate) {
        this.id = id;
        this.balance = balance;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }
}