package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.*;
import com.restarant.SherlockHolms.repos.*;
import com.restarant.SherlockHolms.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    @Value("${upload.path}")
    private String uploadPath;

    private final CommentRepo commentRepo;

    private final MainControllerService mainControllerService;

    private final DessertsService dessertsService;

    private final SnacksService snacksService;

    private final MealsService mealsService;

    private final DrinksService drinksService;

    private final ChefsService chefsService;

    private final BreakfastService breakfastService;

    private final BreakfastRepo breakfastRepo;

    private final DessertsRepo dessertsRepo;

    private final MealsRepo mealsRepo;

    private final DrinksRepo drinksRepo;

    private final ChefsRepo chefsRepo;

    private final ReservationRepo reservationRepo;

    private final SnacksRepo snacksRepo;

    private final ContactUsRepo contactUsRepo;


    public AdminController(BreakfastRepo breakfastRepo, DessertsRepo dessertsRepo, MealsRepo mealsRepo, DrinksRepo drinksRepo, ChefsRepo chefsRepo, ReservationRepo reservationRepo, SnacksRepo snacksRepo, ContactUsRepo contactUsRepo, BreakfastService breakfastService, ChefsService chefsService, DrinksService drinksService, MealsService mealsService, SnacksService snacksService, DessertsService dessertsService, MainControllerService mainControllerService, CommentRepo commentRepo) {
        this.breakfastRepo = breakfastRepo;
        this.dessertsRepo = dessertsRepo;
        this.mealsRepo = mealsRepo;
        this.drinksRepo = drinksRepo;
        this.chefsRepo = chefsRepo;
        this.reservationRepo = reservationRepo;
        this.snacksRepo = snacksRepo;
        this.contactUsRepo = contactUsRepo;
        this.breakfastService = breakfastService;
        this.chefsService = chefsService;
        this.drinksService = drinksService;
        this.mealsService = mealsService;
        this.snacksService = snacksService;
        this.dessertsService = dessertsService;
        this.mainControllerService = mainControllerService;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/AdminPage/Home")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/AdminPage/addBreakFast")
    public String addBreakFast() {
        return "AddFoodBreakfast";
    }

    @PostMapping("/AdminPage/addBreakFast")
    public String addFoodBreakFast(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Breakfast breakfast = new Breakfast();
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);

        breakfastService.saveFile(breakfast, file);
        breakfastRepo.save(breakfast);
        return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addMeals")
    public String addFoodMeals() {
        return "AddFoodMeals";
    }

    @PostMapping("/AdminPage/addMeals")
    public String addFoodMeals(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Meals meals = new Meals();
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);

        mealsService.saveFile(meals, file);
        mealsRepo.save(meals);
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/addSnacks")
    public String addFoodSnacks() {
        return "AddFoodSnacks";
    }

    @PostMapping("/AdminPage/addSnacks")
    public String addFoodSnacks(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Snacks snacks = new Snacks();
        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);

        snacksService.saveFile(snacks, file);

        snacksRepo.save(snacks);
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/addDesserts")
    public String addDessertsFood() {
        return "AddFoodDesserts";
    }

    @PostMapping("/AdminPage/addDesserts")
    public String addDessertsFood(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Desserts desserts = new Desserts();
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);

        dessertsService.saveFile(desserts, file);
        dessertsRepo.save(desserts);
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/addDrinks")
    public String addDrinksFood() {
        return "AddFoodDrinks";
    }

    @PostMapping("/AdminPage/addDrinks")
    public String addDrinksFood(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Drinks drinks = new Drinks();
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);

        drinksService.saveFile(drinks, file);

        drinksRepo.save(drinks);
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/addChefs")
    public String addChefs(Model model) {
        model.addAttribute("positions", PositionChef.values());
        return "AddChefs";
    }

    @PostMapping("/AdminPage/addChefs")
    public String addChefs(
            @RequestParam(name = "FullName") String FullName,
            @RequestParam(name = "position") String position,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        model.addAttribute("positions", PositionChef.values());
        Chefs chefs = new Chefs();
        chefs.setFullName(FullName);

        Set<PositionChef> chefSet = new HashSet<>();
        chefSet.add(PositionChef.valueOf(position));
        chefs.setPositionChefs(chefSet);

        chefsService.saveFile(chefs, file);
        chefsRepo.save(chefs);
        return "redirect:/AdminPage/Home";
    }


    @GetMapping("/AdminPage/listBreakFast")
    public String listofBreakfast(Model model) {
        model.addAttribute("foods", breakfastRepo.findAll());
        return "ListBreakfastFood";
    }

    @GetMapping("/AdminPage/listDrinksFood")
    public String listofDrinks(Model model) {
        model.addAttribute("foods", drinksRepo.findAll());
        return "ListDrinksFood";
    }

    @GetMapping("/AdminPage/listMealsFood")
    public String listofMeals(Model model) {
        model.addAttribute("foods", mealsRepo.findAll());
        return "ListMealsFood";
    }

    @GetMapping("/AdminPage/listDessertsFood")
    public String listofDesserts(Model model) {
        model.addAttribute("foods", dessertsRepo.findAll());
        return "ListDessertsFood";
    }

    @GetMapping("/AdminPage/listSnacksFood")
    public String listofSnacks(Model model) {
        model.addAttribute("foods", snacksRepo.findAll());
        return "ListSnacksFood";
    }

    @GetMapping("/AdminPage/listChefs")
    public String listofChefs(Model model) {
        List<PositionChef> position = Arrays.asList(PositionChef.values());
        model.addAttribute("chefs", chefsRepo.findAll());
        model.addAttribute("position", position);
        return "ListChefs";
    }

    @GetMapping("/AdminPage/listChefs/{chef.id}")
    public String deleteChefById(@PathVariable("chef.id") String parameter) {
        chefsRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/listBreakFast/{breakfast.id}")
    public String deleteBreakfastById(@PathVariable("breakfast.id") String parameter) {
        breakfastRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/listDessertsFood/{desserts.id}")
    public String deleteDessertById(@PathVariable("desserts.id") String parameter) {
        dessertsRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/listDrinksFood/{drinks.id}")
    public String deleteDrinksById(@PathVariable("drinks.id") String parameter) {
        drinksRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/listMealsFood/{meals.id}")
    public String deleteMealsById(@PathVariable("meals.id") String parameter) {
        mealsRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }

    @GetMapping("/AdminPage/listSnacksFood/{snacks.id}")
    public String deleteSnakcsById(@PathVariable("snacks.id") String parameter) {
        snacksRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/Home";
    }


    @GetMapping("/AdminPage/listChefs/Edit/{chef.id}")
    public String EditChef(Model model, @PathVariable("chef.id") String parameter) {
        model.addAttribute("positions", PositionChef.values());
        model.addAttribute("edit",chefsRepo.getOne(Long.parseLong(parameter)));
        return "EditChef";
    }

    @PostMapping("/AdminPage/listChefs/Edit/{chef.id}")
    public String EditChef(
            @PathVariable("chef.id") String parameter,
            @RequestParam(name = "FullName") String FullName,
            @RequestParam(name = "position") String position,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {

        Chefs chef = chefsRepo.getOne(Long.parseLong(parameter));
        chef.setFullName(FullName);
        Set<PositionChef> chefSet = new HashSet<>();
        chefSet.add(PositionChef.valueOf(position));
        chef.setPositionChefs(chefSet);

        model.addAttribute("chefs", chef);

        chefsService.saveFile(chef, file);

        chefsRepo.save(chef);

        return "redirect:/AdminPage/Home";
    }


    @GetMapping("/AdminPage/listBreakFast/Edit/{breakfast.id}")
    public String EditBreakfast(Model model, @PathVariable("breakfast.id") String parameter) {
        model.addAttribute("bk_id", parameter);
        model.addAttribute("edit",breakfastRepo.getOne(Long.parseLong(parameter)));
        return "EditBreakfast";
    }

    @PostMapping("/AdminPage/listBreakFast/Edit/{breakfast.id}")
    public String EditBreakfast(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file,
            @PathVariable("breakfast.id") String parameter)
            throws IOException {
        Breakfast breakfast = breakfastRepo.getOne(Long.parseLong(parameter));
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);
        breakfastService.saveFile(breakfast, file);

        breakfastRepo.save(breakfast);

        return "redirect:/AdminPage/listBreakFast";
    }

    @GetMapping("/AdminPage/listDrinksFood/Edit/{drinks.id}")
    public String EditDrinks(Model model, @PathVariable("drinks.id") String parameter) {
        model.addAttribute("dk_id", parameter);
        model.addAttribute("edit",drinksRepo.getOne(Long.parseLong(parameter)));
        return "EditDrinks";
    }

    @PostMapping("/AdminPage/listDrinksFood/Edit/{drinks.id}")
    public String EditDrinks(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file,
            @PathVariable("drinks.id") String parameter)
            throws IOException {
        Drinks drinks = drinksRepo.getOne(Long.parseLong(parameter));
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);
        drinksService.saveFile(drinks, file);

        drinksRepo.save(drinks);

        return "redirect:/AdminPage/listDrinksFood";
    }

    @GetMapping("/AdminPage/listDessertsFood/Edit/{ds.id}")
    public String EditDesserts(Model model, @PathVariable("ds.id") String parameter) {
        model.addAttribute("ds_id", parameter);
        model.addAttribute("edit",dessertsRepo.getOne(Long.parseLong(parameter)));
        return "EditDrinks";
    }

    @PostMapping("/AdminPage/listDessertsFood/Edit/{ds.id}")
    public String EditDesserts(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file,
            @PathVariable("ds.id") String parameter)
            throws IOException {
        Desserts desserts = dessertsRepo.getOne(Long.parseLong(parameter));
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);
        dessertsService.saveFile(desserts, file);


        dessertsRepo.save(desserts);

        return "redirect:/AdminPage/listDessertsFood";
    }

    @GetMapping("/AdminPage/listMealsFood/Edit/{ml.id}")
    public String EditMeals(Model model, @PathVariable("ml.id") String parameter) {
        model.addAttribute("ml_id", parameter);
        model.addAttribute("edit",mealsRepo.getOne(Long.parseLong(parameter)));
        return "EditMeals";
    }

    @PostMapping("/AdminPage/listMealsFood/Edit/{ml.id}")
    public String EditMeals(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file,
            @PathVariable("ml.id") String parameter)
            throws IOException {
        Meals meals = mealsRepo.getOne(Long.parseLong(parameter));
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);
        mealsService.saveFile(meals, file);


        mealsRepo.save(meals);

        return "redirect:/AdminPage/listMealsFood";

    }

    @GetMapping("/AdminPage/listSnacksFood/Edit/{sn.id}")
    public String EditSnack(Model model, @PathVariable("sn.id") String parameter) {
        model.addAttribute("sn_id", parameter);
        model.addAttribute("edit",snacksRepo.getOne(Long.parseLong(parameter)));
        return "EditSnacks";
    }

    @PostMapping("/AdminPage/listSnacksFood/Edit/{sn.id}")
    public String EditSnacks(
            @RequestParam(name = "name_food") String name_food,
            @RequestParam(name = "cost_food") Integer cost_food,
            @RequestParam(name = "describe_food") String describe_food,
            @RequestParam("file") MultipartFile file,
            @PathVariable("sn.id") String parameter)
            throws IOException {
        Snacks snacks = snacksRepo.getOne(Long.parseLong(parameter));
        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);
        snacksService.saveFile(snacks, file);


        snacksRepo.save(snacks);

        return "redirect:/AdminPage/listSnacksFood";
    }


    @GetMapping("/AdminPage/ListReservation")
    public String listReservation(Model model){
        model.addAttribute("reservs",reservationRepo.findAll());
        model.addAttribute("countP",CountofPeople.values());
        return "ListReservation";
    }

    @GetMapping("/AdminPage/ListContacts")
    public String listContacts(Model model){
        model.addAttribute("conts",contactUsRepo.findAll());
        return "ListContacts";
    }

    @GetMapping("/AdminPage/ListReservation/{res.id}")
    public String deleteResByID(@PathVariable("res.id") String parameter){
        reservationRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/ListReservation" ;
    }

    @GetMapping("/AdminPage/ListContacts/{cot.id}")
    public String deleteContsById(@PathVariable("cot.id") String parameter){
        contactUsRepo.deleteById(Long.parseLong(parameter));
        return "redirect:/AdminPage/ListContacts";
    }

    @GetMapping("/AdminPage/ListReservation/Edit/{res.id}")
    public String EdtiReservationByID(Model model, @PathVariable("res.id") String parameter){
        Reservation reservation = reservationRepo.getOne(Long.parseLong(parameter));
        model.addAttribute("edit",reservationRepo.getOne(Long.parseLong(parameter)));
        return "EditReservation";
    }
    @PostMapping("/AdminPage/ListReservation/Edit/{res.id}")
    public String EditReservationById(
            @RequestParam(name = "Name") String Name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "PhoneNumber") String phoneNumber,
            @RequestParam(name = "countofPeople") String count,
            @RequestParam(name = "dateReservation") String date,
            @RequestParam(name = "message") String message,
            @PathVariable("res.id") String parameter
     ){

        Reservation reservation = reservationRepo.getOne(Long.parseLong(parameter));


         reservation.setName(Name);
        reservation.setEmail(email);
        reservation.setPhoneNumber(phoneNumber);
        Set<CountofPeople> countofPeopleSet = new HashSet<>();
        countofPeopleSet.add(CountofPeople.valueOf(count));
        reservation.setCountofPeople(countofPeopleSet);

        reservation.setMessage(message);
        reservation.setDateReservation(mainControllerService.convertStringtoDate(date));

        reservationRepo.save(reservation);

        return "redirect:/AdminPage/ListReservation";
    }

    @GetMapping("/AdminPage/ListComment")
    public String listComment(Model model){
        model.addAttribute("ListComment",commentRepo.findAll());
        return "ListComment";
    }

}

