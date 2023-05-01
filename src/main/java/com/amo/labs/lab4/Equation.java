package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Equation {
    private double result;
    private double epsilon;
    private double firsta;
    private double secondb;

    private double k;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }


    public double getFirsta() {
        return firsta;
    }

    public void setFirsta(double firsta) {
        this.firsta = firsta;
    }

    public double getSecondb() {
        return secondb;
    }

    public void setSecondb(double secondb) {
        this.secondb = secondb;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double equateMyFunction(double x) {
        return 5 * Math.sin(5 * x) - x;
    }

    public double derivationMyFunction(double x) {
        return  25*Math.cos(5*x) - 1;
    }


    public void iterationMethod(double epsilon, double firsta, double secondb) {
        setFirsta(firsta);
        setSecondb(secondb);
        double x0 = (firsta + secondb)/2;
        int k = 0;
        double x = x0;
        double y = x0;
        do{
            y = x - equateMyFunction(x)/derivationMyFunction(x);
            k++;
            if (Math.abs(y-x)<epsilon){break;}
            else x=y;
        }while (true);
        x0 = y;
        setK(k);
        setResult(x0);
        setEpsilon(epsilon);
    }

    public double phi(double x){
        return (x+5*Math.sin(5 * x)) / 6;
    }
    @Override
    public String toString() {
        return "Equation{" +
                "result=" + result +
                ", epsilon=" + epsilon +
                ", firsta=" + firsta +
                ", secondb=" + secondb +
                ", k=" + k +
                '}';
    }
}
