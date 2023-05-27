package com.amo.labs.lab5;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


import java.util.Arrays;
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EquationForm {
    private double[] solution = new double[3];
    private double[][] coefficients = new double[3][3];
    private double[] constants = new double[3];
    private double omega;
    private double tolerance;
    public EquationForm() {
        tolerance = 1e-6;
        omega = 1.5;
    }

    public double[][] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[][] coefficients) {
        this.coefficients = coefficients;
    }

    public double[] getConstants() {
        return constants;
    }

    public void setConstants(double[] constants) {
        this.constants = constants;
    }

    public double[] getSolution() {
        return solution;
    }

    public void setSolution(double[] solution) {
        this.solution = solution;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getOmega() {
        return omega;
    }

    public void setOmega(double omega) {
        this.omega = omega;
    }

    @Override
    public String toString() {
        return "EquationForm{" +
                "coefficients=" + Arrays.deepToString(coefficients) +
                ", constants=" + Arrays.toString(constants) +
                '}';
    }
}
