package com.amo.labs.lab3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThirdLabController {

    @GetMapping("/lab3")
    public String newInterpoletion(){
        return "lab3";
    }
}
