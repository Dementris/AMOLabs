package com.amo.labs.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ThirdLabController {

    @Autowired
    ThirdLabModel thirdLabModel;
    LabIntrepolation intrepolation = new LabIntrepolation();
    @GetMapping("/lab3")
    public String newInterpoletion(Model model){
        thirdLabModel.startLab(intrepolation);
        double[] x1 = thirdLabModel.setXpointsArrForPlot();
        double[] y1 = thirdLabModel.setYvaluesForPlot(x1);
        double[] x2 = thirdLabModel.setXpointsArr();
        double[] y2 = thirdLabModel.startLab(intrepolation);
        double[] xAcc = thirdLabModel.xAccuracy(x1,x2,2);
        double[][] error = thirdLabModel.error(intrepolation,intrepolation.getxValues(),
                intrepolation.getyValues(),10,x2);
        model.addAttribute("x1", x1);
        model.addAttribute("y1", y1);
        model.addAttribute("x2", x2);
        model.addAttribute("y2", y2);
        model.addAttribute("xAcc", x2);
        model.addAttribute("error", error);
        return "lab3";
    }

}
