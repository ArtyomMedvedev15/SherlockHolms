package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.repos.ChefsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ChefsRepo chefsRepo;

    public MainController(ChefsRepo chefsRepo) {
        this.chefsRepo = chefsRepo;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("chefs",chefsRepo.findAll());

        return "greeting";
    }




}
