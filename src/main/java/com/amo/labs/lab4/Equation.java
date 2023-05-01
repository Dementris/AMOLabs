package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Equation.
 */
@Service
public class Equation {
    private double result;
    private double epsilon;
    private double firsta;
    private double secondb;

    private double k;

    /**
     * Gets result.
     *
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Gets epsilon.
     *
     * @return the epsilon
     */
    public double getEpsilon() {
        return epsilon;
    }

    /**
     * Sets epsilon.
     *
     * @param epsilon the epsilon
     */
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }


    /**
     * Gets firsta.
     *
     * @return the firsta
     */
    public double getFirsta() {
        return firsta;
    }

    /**
     * Sets firsta.
     *
     * @param firsta the firsta
     */
    public void setFirsta(double firsta) {
        this.firsta = firsta;
    }

    /**
     * Gets secondb.
     *
     * @return the secondb
     */
    public double getSecondb() {
        return secondb;
    }

    /**
     * Sets secondb.
     *
     * @param secondb the secondb
     */
    public void setSecondb(double secondb) {
        this.secondb = secondb;
    }

    /**
     * Gets k.
     *
     * @return the k
     */
    public double getK() {
        return k;
    }

    /**
     * Sets k.
     *
     * @param k the k
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * Equate my function double.
     *
     * @param x the x
     * @return the double
     */
    public double equateMyFunction(double x) {
        return 5 * Math.sin(5 * x) - x;
    }

    /**
     * Derivation my function double.
     *
     * @param x the x
     * @return the double
     */
    public double derivationMyFunction(double x) {
        return  25*Math.cos(5*x) - 1;
    }


    /**
     * Method which find result of equation.
     *
     * @param epsilon the epsilon or tolerance
     * @param firsta  the first bound of range
     * @param secondb the last bound of range
     */
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

    /**
     * Phi double.
     *
     * @param x the x
     * @return the double
     */
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
