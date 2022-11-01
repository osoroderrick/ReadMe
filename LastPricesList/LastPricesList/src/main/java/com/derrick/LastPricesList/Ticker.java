package com.derrick.LastPricesList;

public class Ticker {
    private double ask;
    private double bid;

    public Ticker(){

    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
