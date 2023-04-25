package com.amo.labs.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FourthLabController {

    @Autowired
    Equation equation;

    @Autowired
    FourthLabModel fourthLabModel;

    @GetMapping("/lab4")
    public String newEquation(){
        fourthLabModel.startlab();
        return "lab4";
    }
}
