package com.amo.labs.lab4;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Plotter {
    private double[] x;
    private double[] y;

    List<double[]> intervals = new ArrayList<>();

    public Plotter(double start, double stop, double step) {
        this.x = generateXvalues(start,stop,step);
        this.y = generateYvalues(this.x);
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public List<double[]> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<double[]> intervals) {
        this.intervals = intervals;
    }

    private double[] generateXvalues(double start, double stop, double step){

        List<Double> arr = new ArrayList<>();
        for (double i = start; i <=stop ; i+=step) {
            arr.add(i);
        }
        double[] x = new double[arr.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = arr.get(i);
        }
        return x;
    }
    private double[] generateYvalues(double[] xList){
        double[] y = new double[xList.length];
        for (int i = 0; i < xList.length; i++) {
            y[i] = 5 * Math.sin(5 * xList[i]) - xList[i];
        }
        return y;
    }
}
