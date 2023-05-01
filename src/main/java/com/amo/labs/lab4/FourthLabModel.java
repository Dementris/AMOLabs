package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FourthLabModel {

    Equation equation;

    public FourthLabModel(Equation equation) {
        this.equation = equation;
    }

    public Equation getEquation() {
        return equation;
    }

    public double convert(String str)
    {
        double val = 0;
        try {
            val = Double.parseDouble(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid String");
        }
        return val;
    }
    public List<double[]> findIntervalsOfMonotony(double[] x, double[] y) {
        List<double[]> intervals = new ArrayList<>();
        int n = x.length;

        if (n != y.length) {
            throw new IllegalArgumentException("Arrays x and y must have the same length");
        }

        double[] derivative = new double[n-1];

        for (int i = 0; i < n - 1; i++) {
            double deltaX = x[i+1] - x[i];
            double deltaY = y[i+1] - y[i];
            derivative[i] = deltaY / deltaX;
        }


        boolean increasing = false;
        boolean decreasing = false;
        double intervalStart = x[0];

        for (int i = 0; i < n - 2; i++) {
            double currentDerivative = derivative[i];

            if (currentDerivative > 0) {
                increasing = true;
                decreasing = false;
            } else if (currentDerivative < 0) {
                increasing = false;
                decreasing = true;
            }

            if (increasing && derivative[i + 1] < 0) {
                intervals.add(new double[]{Math.round(intervalStart * 100.0) / 100.0, Math.round(x[i + 1] * 100.0) / 100.0});
                increasing = false;
                intervalStart = x[i + 1];
            } else if (decreasing && derivative[i + 1] > 0) {
                intervals.add(new double[]{Math.round(intervalStart * 100.0) / 100.0, Math.round(x[i + 1] * 100.0) / 100.0});
                decreasing = false;
                intervalStart = x[i + 1];
            }
        }

        if (increasing) {
            intervals.add(new double[]{Math.round(intervalStart * 100.0) / 100.0, Math.round(x[n - 1] * 100.0) / 100.0});
        } else if (decreasing) {
            intervals.add(new double[]{Math.round(intervalStart * 100.0) / 100.0, Math.round(x[n - 1] * 100.0) / 100.0});
        }
        intervals.remove(16);
        intervals.remove(0);
        return intervals;
    }


    public void startlab(double epsilon, double a, double b){
        equation.iterationMethod(epsilon,a,b);
    }
}
