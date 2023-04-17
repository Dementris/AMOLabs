package com.amo.labs.lab3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Service
public class ThirdLabModel {

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

    public double[] setXpointsArr(){
        double h = 0.2;
        double[] xVal = new double[11];
        for (int i = 0; i < 11; i++) {
            xVal[i] = h*i;
        }
        return xVal;
    }

    public void setYvalues(LabIntrepolation intrepolation){
        double[] xVal = intrepolation.getxValues();
        int n = xVal.length;
        double[] yVal = new double[n];
        for (int i = 0; i < n; i++) {
            yVal[i] = Math.pow(4,xVal[i]) - 8*xVal[i];
        }
        intrepolation.setyValues(yVal);
    }

    public double[] startLab(LabIntrepolation intrepolation){
        setYvalues(intrepolation);
        double[] interpolatedX = setXpointsArr();
        double[] resultInterpolation = new double[interpolatedX.length];
        for (int i = 0; i < interpolatedX.length; i++) {
            resultInterpolation[i] = intrepolation.interpolate(interpolatedX[i]);
        }
        double i = intrepolation.interpolate(0.89);
        System.out.println("Interpolated value "+i);
        return resultInterpolation;
    }
}
