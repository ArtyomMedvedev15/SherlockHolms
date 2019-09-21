package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.Breakfast;
import com.restarant.SherlockHolms.domain.ContactUs;
import com.restarant.SherlockHolms.domain.CountofPeople;
import com.restarant.SherlockHolms.domain.PositionChef;
import com.restarant.SherlockHolms.repos.*;
import com.restarant.SherlockHolms.service.BreakfastService;
import com.restarant.SherlockHolms.service.MainControllerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final ChefsRepo chefsRepo;

    private final BreakfastRepo breakfastRepo;

    private final CommentRepo commentRepo;

    private final ReservationRepo reservationRepo;

    private final MainControllerService mainControllerService;

    private final ContactUsRepo contactUsRepo;

    private final BreakfastService breakfastService;

    public MainController(ChefsRepo chefsRepo, BreakfastRepo breakfastRepo, ReservationRepo reservationRepo, MainControllerService mainControllerService, ContactUsRepo contactUsRepo, CommentRepo commentRepo, BreakfastService breakfastService) {
        this.chefsRepo = chefsRepo;
        this.breakfastRepo = breakfastRepo;
        this.reservationRepo = reservationRepo;
        this.mainControllerService = mainControllerService;
        this.contactUsRepo = contactUsRepo;
        this.commentRepo = commentRepo;
        this.breakfastService = breakfastService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("chefs",chefsRepo.findAll());
        model.addAttribute("position", PositionChef.values());
        model.addAttribute("counts", CountofPeople.values());
        model.addAttribute("CustomersList",commentRepo.findAll());
        Map<String,List<Breakfast>> res = breakfastService.cutMassiveontwohalf(breakfastRepo.findAll());
        model.addAttribute("left",res.get("left"));
        model.addAttribute("right",res.get("right"));

        return "greeting";
    }

    @PostMapping("/Reservation")
    public String addReservation(
            @RequestParam(name = "Name")String Name,
            @RequestParam(name = "email")String email,
            @RequestParam(name = "PhoneNumber")String phoneNumber,
            @RequestParam(name = "countofPeople")String count,
            @RequestParam(name = "dateReservation")String date,
            @RequestParam(name = "message")String message
            ){

           mainControllerService.addReservation(Name,email,phoneNumber,count,date,message);
        return "redirect:/";
    }

    @PostMapping("/ContactsForms")
    public String addContactsUs(
        @RequestParam(name = "name")String name,
        @RequestParam(name = "email")String email,
        @RequestParam(name = "subject")String subject,
        @RequestParam(name = "message")String message
    ){

        ContactUs contactUs = new ContactUs(name,email,subject,message);
        contactUsRepo.save(contactUs);

        return "redirect:/";
    }






}
