package com.amo.labs.lab3;

public class InterPoltionError {
    private double deltan;
    private double deltaEcactn;
    private double k;
    private double n;

    public InterPoltionError(double deltan, double deltaEcactn, double k, double n) {
        this.deltan = deltan;
        this.deltaEcactn = deltaEcactn;
        this.k = k;
        this.n = n;
    }

    public double getDeltan() {
        return deltan;
    }

    public void setDeltan(double deltan) {
        this.deltan = deltan;
    }

    public double getDeltaEcactn() {
        return deltaEcactn;
    }

    public void setDeltaEcactn(double deltaEcactn) {
        this.deltaEcactn = deltaEcactn;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
