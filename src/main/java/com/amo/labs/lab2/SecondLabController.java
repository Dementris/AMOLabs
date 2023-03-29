package com.amo.labs.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Controller
public class SecondLabController {
    private final AlgorithmData algorithmData = new AlgorithmData();
    @Autowired
    SecondLabModel secondLabModel;

    @GetMapping("/lab2")
    public String newAlghoritm(Model model){
        model.addAttribute("alghoritm", new Algorithms());
        return "lab2";
    }

    @ModelAttribute("algModelAttribute")
    AlgorithmData algModelAttribute(){
        return algorithmData;
    }

    @PostMapping("/lab2")
    public String sortRequest(@ModelAttribute("alghoritm") Algorithms algorithms,ModelMap map){
        secondLabModel.stringArrtoInt(algorithms);
        if (algorithms.getFirstArray().length == 1 || algorithms.getFirstArray()[0] == 0){
            map.put("errorMessage","PLEASE ENTER COMMA SEPARATED NUMBERS");
            return "lab2";
        }
        secondLabModel.binarySort(algorithms);
        algorithmData.save(algorithms);
        algorithmData.addPlotParams(algorithms);
        System.out.println(algorithmData.getLengthTimeFeauter());
        for (int[] lists: algorithmData.getLengthTimeFeauter().values()) {
            System.out.println(Arrays.toString(lists));
        }
        return "lab2";
    }



}
