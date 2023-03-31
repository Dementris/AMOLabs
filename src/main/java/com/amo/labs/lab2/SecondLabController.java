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

/**
 * The type Second lab controller.
 */
@Controller
public class SecondLabController {
    private final AlgorithmData algorithmData = new AlgorithmData();
    /**
     * The Second lab model.
     */
    @Autowired
    SecondLabModel secondLabModel;

    /**
     * Create new Algorithm in /lab2.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/lab2")
    public String newAlghoritm(Model model){
        model.addAttribute("alghoritm", new Algorithms());
        return "lab2";
    }

    /**
     * Alg model attribute algorithm data.
     *
     * @return the algorithm data
     */
    @ModelAttribute("algModelAttribute")
    AlgorithmData algModelAttribute(){
        return algorithmData;
    }


    /**
     * Post request for add first data to algorithm.
     *
     * @param algorithms the algorithms
     * @param map        the map
     * @return the string
     */
    @PostMapping("/lab2")
    public String sortRequest(@ModelAttribute("alghoritm") Algorithms algorithms,ModelMap map){
        secondLabModel.stringArrtoInt(algorithms);
        if (algorithms.getFirstArray().length == 1 || algorithms.getFirstArray()[0] == 0){
            map.put("errorMessage","PLEASE ENTER COMMA SEPARATED NUMBERS");
            return "lab2";
        }
        else if (algorithms.getFirstArray().length>=1024){
            map.put("errorMessage","Enter an array with a length less than 1024");
            return "lab2";
        }
        secondLabModel.binarySort(algorithms);
        algorithmData.save(algorithms);
        algorithmData.addPlotParams(algorithms);
        return "lab2";
    }



}
