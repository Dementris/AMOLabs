package com.amo.labs.tets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexContreller {

    @GetMapping("/test")
    public String index(Model model){
        model.addAttribute("userForm",new User());
        return "user";
    }

    @PostMapping("/test")
    public String registerUser(@ModelAttribute User user,Model model){
        System.out.println(user.toString());
        model.addAttribute("userForm",new User());
        return "user";
    }

}
