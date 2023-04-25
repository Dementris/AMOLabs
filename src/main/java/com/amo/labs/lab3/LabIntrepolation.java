package com.amo.labs.lab3;

import java.util.Arrays;

public class LabIntrepolation {
    private double[] xValues = {0, 0.1, 0.3, 0.5, 0.7, 0.9, 1, 1.1, 1.3, 1.5, 1.7, 1.9, 2};
    private double[] yValues;

    private String firstData;
    private String degreeData;
    private double xi;

    private double degree = 10;


    public double interpolate(double[] x, double[] y, double xi, int degree) {
        int n = degree;
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
            a[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                a[i][j] = ((xi - x[i]) * a[i + 1][j - 1] - (xi - x[i + j]) * a[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return a[0][n - 1];
    }


    public void setxValues(double[] xValues) {
        this.xValues = xValues;
    }

    public void setyValues(double[] yValues) {
        this.yValues = yValues;
    }

    public double[] getxValues() {
        return xValues;
    }

    public double[] getyValues() {
        return yValues;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getFirstData() {
        return firstData;
    }

    public void setFirstData(String firstData) {
        this.firstData = firstData;
    }

    public String getDegreeData() {
        return degreeData;
    }

    public void setDegreeData(String degreeData) {
        this.degreeData = degreeData;
    }
}
