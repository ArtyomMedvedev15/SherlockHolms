package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.ContactUs;
import com.restarant.SherlockHolms.domain.CountofPeople;
import com.restarant.SherlockHolms.domain.PositionChef;
import com.restarant.SherlockHolms.domain.Reservation;
import com.restarant.SherlockHolms.repos.BreakfastRepo;
import com.restarant.SherlockHolms.repos.ChefsRepo;
import com.restarant.SherlockHolms.repos.ContactUsRepo;
import com.restarant.SherlockHolms.repos.ReservationRepo;
import com.restarant.SherlockHolms.service.MainControllerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    private final ChefsRepo chefsRepo;

    private final BreakfastRepo breakfastRepo;

    private final ReservationRepo reservationRepo;

    private final MainControllerService mainControllerService;

    private final ContactUsRepo contactUsRepo;

    public MainController(ChefsRepo chefsRepo, BreakfastRepo breakfastRepo, ReservationRepo reservationRepo, MainControllerService mainControllerService, ContactUsRepo contactUsRepo) {
        this.chefsRepo = chefsRepo;
        this.breakfastRepo = breakfastRepo;
        this.reservationRepo = reservationRepo;
        this.mainControllerService = mainControllerService;
        this.contactUsRepo = contactUsRepo;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("chefs",chefsRepo.findAll());
        model.addAttribute("position", PositionChef.values());
        model.addAttribute("break1",breakfastRepo.getOne((long) 3));
        model.addAttribute("counts", CountofPeople.values());
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
