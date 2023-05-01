package com.amo.labs.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<double[]> intervals = fourthLabModel.findIntervalsOfMonotony(x,y);
        String strIntervals = intervals.stream().map(Arrays::toString).collect(Collectors.joining(", ", "[", "]"));
        model.addAttribute("intervals",strIntervals);
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("zeros", zeros);
        model.addAttribute("equationData",dataEquation);
        model.addAttribute("equation",equation);
        return "lab4";
    }

    @PostMapping("/lab4")
    public String getPostRequest(@ModelAttribute("equationData") DataEquation data, RedirectAttributes redirectAttributes) {
        double epsilon = fourthLabModel.convert(data.getStringEpsilon());
        double start = fourthLabModel.convert(data.getStart());
        double stop = fourthLabModel.convert(data.getStop());
        if (stop-start<0){
            redirectAttributes.addFlashAttribute("errorMessage","Please enter valid numbers for range");
            return "redirect:/lab4";
        }else if (equation.equateMyFunction(start)*equation.equateMyFunction(stop)>=0){
            redirectAttributes.addFlashAttribute("errorMessage","Please enter valid numbers for range");
            return "redirect:/lab4";
        }
        fourthLabModel.startlab(epsilon,start,stop);
        return "redirect:/lab4";
    }
}
