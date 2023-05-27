package com.amo.labs.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class FivesLabController {

    private final EquationForm equationForm = new EquationForm();

    @ModelAttribute("equationFormData")
    EquationForm equationForm(){
        return equationForm;
    }

    @GetMapping("/lab5")
    public String lab5(@ModelAttribute("equationFormData") EquationForm formData, ModelMap map) {
        map.put("solution",formData.getSolution() );
        return "lab5";
    }

    @PostMapping("/solve-equations")
    public String solveEquations(@ModelAttribute("equationFormData") EquationForm formData) {
        System.out.println(formData);
        double[][] matrix = formData.getCoefficients();
        double[] b = formData.getConstants();
        double[] x = new double[3];
        double omega = formData.getOmega();
        int maxIterations = 1000;
        double tolerance = formData.getTolerance();

        UpperRelaxationMethodSolver.solver(matrix, b, x, omega, maxIterations, tolerance);

        System.out.println("Solution:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        formData.setSolution(x);

        return "redirect:/lab5";
    }
}
