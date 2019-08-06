package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.*;
import com.restarant.SherlockHolms.repos.*;
import com.restarant.SherlockHolms.service.MainControllerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private final ChefsRepo chefsRepo;

    private final BreakfastRepo breakfastRepo;

    private final CommentRepo commentRepo;

    private final ReservationRepo reservationRepo;

    private final MainControllerService mainControllerService;

    private final ContactUsRepo contactUsRepo;

    public MainController(ChefsRepo chefsRepo, BreakfastRepo breakfastRepo, ReservationRepo reservationRepo, MainControllerService mainControllerService, ContactUsRepo contactUsRepo, CommentRepo commentRepo) {
        this.chefsRepo = chefsRepo;
        this.breakfastRepo = breakfastRepo;
        this.reservationRepo = reservationRepo;
        this.mainControllerService = mainControllerService;
        this.contactUsRepo = contactUsRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Breakfast> RightSideBreakFast = new ArrayList<>();
        List<Breakfast> LeftSideBreakFast = new ArrayList<>();
        List<Meals>RightSideMeals = new ArrayList<>();
        List<Meals>LeftSideMeals = new ArrayList<>();
        List<Meals>RightSideDrinks = new ArrayList<>();
        List<Meals>LeftSideDrinks = new ArrayList<>();
        List<Meals>RightSideSnacks = new ArrayList<>();
        List<Meals>LeftSideSnakcs = new ArrayList<>();
        List<Meals>RightSideDesserts = new ArrayList<>();
        List<Meals>LeftSideDesserts = new ArrayList<>();



        model.addAttribute("chefs",chefsRepo.findAll());
        model.addAttribute("position", PositionChef.values());
        model.addAttribute("counts", CountofPeople.values());
        model.addAttribute("CustomersList",commentRepo.findAll());
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
        Reservation reservation = new Reservation();
        reservation.setName(Name);

        Set<CountofPeople> countofPeopleSet = new HashSet<>();
        countofPeopleSet.add(CountofPeople.valueOf(count));
        reservation.setCountofPeople(countofPeopleSet);
        reservation.setEmail(email);

        reservation.setMessage(message);
        reservation.setDateReservation(mainControllerService.convertStringtoDate(date));
        reservation.setPhoneNumber(phoneNumber);
         reservationRepo.save(reservation);
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
