package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

@Service
public class Equation {
    private double result;
    private double epsilon;
    private int firsta = 0;
    private int secondb = 10;

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


    public int getFirsta() {
        return firsta;
    }

    public void setFirsta(int firsta) {
        this.firsta = firsta;
    }

    public int getSecondb() {
        return secondb;
    }

    public void setSecondb(int secondb) {
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

    public double derivationMyFunction(double x){
        return 25 * Math.cos(5*x)-1;
    }

    public boolean isCorrectAandB(){
        return secondb - firsta > 0;
    }

    public void iterationMethod(double x0,double epsilon){
        if (equateMyFunction(firsta)*equateMyFunction(secondb)<0){
            int k = 0;
            double x = x0;
            double y = x - (equateMyFunction(x)/derivationMyFunction(x));
            while (Math.abs(y-x)>=epsilon){
                x = y;
                y = x - (equateMyFunction(x)/derivationMyFunction(x));
                k++;
            }
            x0 = y;
            setResult(x0);
            setK(k);
            }
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
