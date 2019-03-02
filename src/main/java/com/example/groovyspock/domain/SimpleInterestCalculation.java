package com.example.groovyspock.domain;

public class SimpleInterestCalculation {

    private double rate;
    private double getRate(){
        return rate;
    }

    public void setRate(double rate){
        this.rate = rate;
    }

    public double calculate(double amount , double year){
        if(amount < 0 || year < 0){
            throw new IllegalArgumentException("Amount or year must be positive");
        }
        return amount * rate * year;
    }

    public double subtract(double value1 , double value2){
        return value1 - value2;
    }
}
