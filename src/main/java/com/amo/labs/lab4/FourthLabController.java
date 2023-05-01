package com.amo.labs.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FourthLabController {

    @Autowired
    Equation equation;

    @Autowired
    FourthLabModel fourthLabModel;

    DataEquation dataEquation = new DataEquation();

    @GetMapping("/lab4")
    public String newEquation(Model model){
        Plotter plotter = new Plotter(-5,5,0.01);
        double[] x = plotter.getX();
        double[] y = plotter.getY();
        double[] zeros = new double[x.length];
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("zeros", zeros);
        model.addAttribute("equationData",dataEquation);
        return "lab4";
    }

    @PostMapping("/lab4")
    public String getPostRequest(@ModelAttribute("equationData") DataEquation data){
        System.out.println(data.toString());

        return "redirect:/lab4";
    }
}
