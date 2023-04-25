package com.amo.labs.lab4;

import org.springframework.stereotype.Service;

@Service
public class FourthLabModel {

    Equation equation;

    public FourthLabModel(Equation equation) {
        this.equation = equation;
    }

    public void startlab(){
        equation.iterationMethod(2.6,6);
        System.out.println(equation.toString());
    }
}
