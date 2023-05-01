package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Equation {
    private double result;
    private double epsilon;
    private double firsta = -5;
    private double secondb = -4;

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
        return (0.2) * Math.asin(x / 5.0);
    }

    public boolean isCorrectAandB() {
        return secondb - firsta > 0;
    }

    public void iterationMethod(double epsilon, double firsta, double secondb) {
        setFirsta(firsta);
        setSecondb(secondb);
        double x0 = secondb + (firsta - secondb) / 2;
        System.out.println(x0);
        if (equateMyFunction(firsta) * equateMyFunction(secondb) < 0) {
            int k = 0;
            double x = x0;
            while (Math.abs(x-derivationMyFunction(x)) > epsilon){
                x = derivationMyFunction(x);
                k++;
            }
            setResult(x);
            setK(k);
            setEpsilon(epsilon);

        } else System.out.println("Enter another range");
    }

    public double phi(double x){
        return 5*Math.sin(x)/((5 - Math.sqrt(21)) / 2) + (1-((5 - Math.sqrt(21)) / 2))*x;
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
