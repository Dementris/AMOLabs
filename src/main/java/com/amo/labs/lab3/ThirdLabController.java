package com.amo.labs.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ThirdLabController {

    @Autowired
    ThirdLabModel thirdLabModel;

    @Autowired
    ErrorsDAO errorsDAO;

    LabIntrepolation intrepolation = new LabIntrepolation();
    @GetMapping("/lab3")
    public String newInterpoletion(Model model){
        thirdLabModel.startLab(intrepolation);
        double[] x1 = thirdLabModel.setXpointsArrForPlot();
        double[] y1 = thirdLabModel.setYvaluesForPlot(x1);
        double[] x2 = thirdLabModel.setXpointsArr();
        double[] y2 = thirdLabModel.startLab(intrepolation);
        double[][] error = thirdLabModel.error(intrepolation,intrepolation.getxValues(),
                intrepolation.getyValues(),10,x2);
        model.addAttribute("interpolation",intrepolation);
        model.addAttribute("x1", x1);
        model.addAttribute("y1", y1);
        model.addAttribute("x2", x2);
        model.addAttribute("y2", y2);
        model.addAttribute("error", error);
        return "lab3";
    }

    @ModelAttribute("errorsData")
    ErrorsDAO errorsDAO(){return errorsDAO;}

    @PostMapping("/lab3")
    public String getPostRequest(@ModelAttribute("interpolation") LabIntrepolation lab){
        errorsDAO.getErrors().clear();
        intrepolation.setXi(thirdLabModel.convert(lab.getFirstData()));
        intrepolation.setDegree(thirdLabModel.convert(lab.getDegreeData()));
        thirdLabModel.tableOfContent(intrepolation,errorsDAO);
        return "redirect:/lab3";
    }

}
