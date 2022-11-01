package com.derrick.LastPricesList;

public class Bitcoin {
    private String created_on;
    private int unix_time;
    private char expiration_time_unix;
    private Ticker ticker;
    private Market market;
    private double rate;
    private String rate_id;
    private boolean allowed_historic_price_variance;
    private boolean allowed_historic_price_age;



    public Bitcoin(){

    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public int getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(int unix_time) {
        this.unix_time = unix_time;
    }

    public char getExpiration_time_unix() {
        return expiration_time_unix;
    }

    public void setExpiration_time_unix(char expiration_time_unix) {
        this.expiration_time_unix = expiration_time_unix;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public Market getMarket() {
        return market;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRate_id() {
        return rate_id;
    }

    public void setRate_id(String rate_id) {
        this.rate_id = rate_id;
    }

    public boolean isAllowed_historic_price_variance() {
        return allowed_historic_price_variance;
    }

    public void setAllowed_historic_price_variance(boolean allowed_historic_price_variance) {
        this.allowed_historic_price_variance = allowed_historic_price_variance;
    }

    public boolean isAllowed_historic_price_age() {
        return allowed_historic_price_age;
    }

    public void setAllowed_historic_price_age(boolean allowed_historic_price_age) {
        this.allowed_historic_price_age = allowed_historic_price_age;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "created_on='" + created_on + '\'' +
                ", unix_time=" + unix_time +
                ", expiration_time_unix=" + expiration_time_unix +
                ", ticker=" + ticker +
                ", market=" + market +
                ", rate=" + rate +
                ", rate_id='" + rate_id + '\'' +
                ", allowed_historic_price_variance=" + allowed_historic_price_variance +
                ", allowed_historic_price_age=" + allowed_historic_price_age +
                '}';
    }
}
