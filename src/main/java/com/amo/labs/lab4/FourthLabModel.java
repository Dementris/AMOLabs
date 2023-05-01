package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

@Service
public class FourthLabModel {

    Equation equation;

    public FourthLabModel(Equation equation) {
        this.equation = equation;
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

    public void startlab(double epsilon, double a, double b){
        equation.iterationMethod(epsilon,a,b);
        System.out.println(equation.toString());
    }
}
