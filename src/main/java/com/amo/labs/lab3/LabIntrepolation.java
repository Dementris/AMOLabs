package com.amo.labs.lab3;

public class LabIntrepolation {
    double[] xValues = {0, 0.1, 0.3, 0.5, 0.7, 0.9, 1, 1.1, 1.3, 1.5, 1.7, 1.9, 2};
    double[] yValues;


    public  double interpolate(double x) {
        int n = xValues.length;
        double[] f = new double[n];

        for (int i = 0; i < n; i++) {
            f[i] = yValues[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n-j; i++) {
                f[i] = ((x - xValues[i+j]) * f[i] + (xValues[i] - x) * f[i+1]) / (xValues[i] - xValues[i+j]);
            }
        }

        return f[0];
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
}
