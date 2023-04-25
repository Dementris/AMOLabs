package com.amo.labs.lab3;

import org.springframework.stereotype.Service;

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

    public double[] setXpointsArrForPlot(){
        double h = 0.1;
        double[] xVal = new double[21];
        for (int i = 0; i < 21; i++) {
            xVal[i] = h*i;
        }
        return xVal;
    }

    public double[] setYvaluesForPlot(double[] xVal){
        int n = xVal.length;
        double[] yVal = new double[n];
        for (int i = 0; i < n; i++) {
            yVal[i] = Math.pow(4,xVal[i])-8*xVal[i];
        }
        return yVal;
    }

    public void setYvalues(LabIntrepolation intrepolation){
        double[] xVal = intrepolation.getxValues();
        int n = xVal.length;
        double[] yVal = new double[n];
        for (int i = 0; i < n; i++) {
            yVal[i] = Math.pow(4,xVal[i])-8*xVal[i];
        }
        intrepolation.setyValues(yVal);
    }

    public double[][] error(LabIntrepolation lab,double[] xi, double[] yi, int degree, double[] xWithLine){
        setYvalues(lab);
        int l = xWithLine.length;
        double[][] logErr = new double[degree][l];
        for (int n = 1; n < degree ; n++) {
            for (int i = 0; i < l; i++) {
                logErr[n-1][i] = -1*Math.log10(Math.abs(lab.interpolate(xi,yi,xWithLine[i],n)-lab.interpolate(xi,yi,xWithLine[i],n+1)));
            }
        }
        for (int i = 0; i < logErr.length; i++) {
            for (int j = 0; j < logErr[i].length; j++) {
                if (logErr[i][j]==Double.POSITIVE_INFINITY){
                    logErr[i][j] = logErr[i][j+1];
                }
            }
        }
        return logErr;
    }

    public void tableOfContent(LabIntrepolation lab, ErrorsDAO errorsDAO){
        int degree = (int) lab.getDegree();
        double xi = lab.getXi();
        double deltan, deltaExactN, k;
        for (int n = 1; n < degree+1; n++) {
            deltan = lab.interpolate(lab.getxValues(),lab.getyValues(),xi,n)-lab.interpolate(lab.getxValues(),lab.getyValues(),xi,n+1);
            deltaExactN = lab.interpolate(lab.getxValues(),lab.getyValues(),xi,n) - (Math.pow(4,xi)-8*xi);
            k = 1 - (deltaExactN/deltan);
            InterPoltionError error = new InterPoltionError(deltan,deltaExactN,k,n);
            errorsDAO.save(error);
        }
    }

    public double[] xAccuracy(double[] x ,double[] xj ,int j){
        double[] xWithLine = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            xWithLine[i] = (x[i]-xj[j])/(xj[j+1]-xj[j]);
        }
        return xWithLine;
    }

    public double[] startLab(LabIntrepolation intrepolation){
        setYvalues(intrepolation);
        int degree = (int) intrepolation.getDegree();
        double[] interpolatedX = setXpointsArr();
        double[] resultInterpolation = new double[interpolatedX.length];
        for (int i = 0; i < interpolatedX.length; i++) {
            resultInterpolation[i] = intrepolation.interpolate(intrepolation.getxValues(),intrepolation.getyValues(),interpolatedX[i],degree);
        }
        return resultInterpolation;
    }
}
