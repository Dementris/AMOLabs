package com.amo.labs.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecondLabController {

    public final int COUNT = 0;
    @Autowired
    SecondLabModel secondLabModel;
    AlgorithmsDB algorithmsDB;

    @GetMapping("/lab2")
    public String newAlghoritm(Model model){
        model.addAttribute("alghoritm",new Algorithms());
        return "lab2";
    }

    @PostMapping("/lab2")
    public String sortRequest(@ModelAttribute Algorithms algorithms, Model model){
        secondLabModel.stringArrtoInt(algorithms);
        secondLabModel.binarySort(algorithms);
        algorithms.setID(COUNT+1);
        System.out.println(algorithms.toString());
        model.addAttribute("alghoritm",new Algorithms());
        model.addAttribute("sorted",algorithms.toString());
        return "lab2";
    }



}
