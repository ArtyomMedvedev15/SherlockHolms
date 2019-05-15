package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.*;
import com.restarant.SherlockHolms.repos.*;
import com.restarant.SherlockHolms.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    public AdminController(BreakfastRepo breakfastRepo, DessertsRepo dessertsRepo, MealsRepo mealsRepo, DrinksRepo drinksRepo, ChefsRepo chefsRepo, ReservationRepo reservationRepo, SnacksRepo snacksRepo, ContactUsRepo contactUsRepo, BreakfastService breakfastService, ChefsService chefsService, DrinksService drinksService, MealsService mealsService, SnacksService snacksService, DessertsService dessertsService) {
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
    }

    @GetMapping("/AdminPage")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/AdminPage/addBreakFast")
    public String addBreakFast(){
        return "AddFoodBreakfast";
    }

    @PostMapping("/AdminPage/addBreakFast")
    public String addFoodBreakFast(
        @RequestParam(name = "name_food")String name_food,
        @RequestParam(name = "cost_food")Integer cost_food,
        @RequestParam(name = "describe_food")String describe_food,
        @RequestParam("file") MultipartFile file
        ) throws IOException {
        Breakfast breakfast = new Breakfast();
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);

        breakfastService.saveFile(breakfast,file);
        breakfastRepo.save(breakfast);
     return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addMeals")
    public String addFoodMeals(){
        return "AddFoodMeals";
    }

    @PostMapping("/AdminPage/addMeals")
    public String addFoodMeals(
            @RequestParam(name = "name_food")String name_food,
            @RequestParam(name = "cost_food")Integer cost_food,
            @RequestParam(name = "describe_food")String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Meals meals = new Meals();
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);

        mealsService.saveFile(meals,file);
         mealsRepo.save(meals);
        return "redirect:/AdminPage";
    }
    @GetMapping("/AdminPage/addSnacks")
    public String addFoodSnacks(){
        return "AddFoodSnacks";
    }

    @PostMapping("/AdminPage/addSnacks")
    public String addFoodSnacks(
            @RequestParam(name = "name_food")String name_food,
            @RequestParam(name = "cost_food")Integer cost_food,
            @RequestParam(name = "describe_food")String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Snacks snacks = new Snacks();
        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);

        snacksService.saveFile(snacks,file);

        snacksRepo.save(snacks);
        return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addDesserts")
    public String addDessertsFood(){
        return "AddFoodDesserts";
    }

    @PostMapping("/AdminPage/addDesserts")
    public String addDessertsFood(
            @RequestParam(name = "name_food")String name_food,
            @RequestParam(name = "cost_food")Integer cost_food,
            @RequestParam(name = "describe_food")String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Desserts desserts = new Desserts();
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);

        dessertsService.saveFile(desserts,file);
        dessertsRepo.save(desserts);
        return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addDrinks")
    public String addDrinksFood(){
        return "AddFoodDrinks";
    }

    @PostMapping("/AdminPage/addDrinks")
    public String addDrinksFood(
            @RequestParam(name = "name_food")String name_food,
            @RequestParam(name = "cost_food")Integer cost_food,
            @RequestParam(name = "describe_food")String describe_food,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Drinks drinks = new Drinks();
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);

        drinksService.saveFile(drinks,file);

        drinksRepo.save(drinks);
        return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addChefs")
    public String addChefs(Model model){
        model.addAttribute("positions",PositionChef.values());
        return "AddChefs";
    }

    @PostMapping("/AdminPage/addChefs")
    public String addChefs(
            @RequestParam(name = "FullName")String FullName,
            @RequestParam(name = "position")String position,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        model.addAttribute("positions",PositionChef.values());
        Chefs chefs = new Chefs();
        chefs.setFullName(FullName);

        Set<PositionChef>chefSet = new HashSet<>();
        chefSet.add(PositionChef.valueOf(position));
        chefs.setPositionChefs(chefSet);

        chefsService.saveFile(chefs,file);
        chefsRepo.save(chefs);
        return "redirect:/AdminPage";
    }


    @GetMapping("/AdminPage/listBreakFast")
    public String listofBreakfast(Model model){
        List<Breakfast> breakfasts = breakfastRepo.findAll();
        model.addAttribute("foods",breakfasts);
        return "ListBreakfastFood";
    }

    @GetMapping("/AdminPage/listDrinksFood")
    public String listofDrinks(Model model){
        List<Drinks> drinks = drinksRepo.findAll();
        model.addAttribute("foods",drinks);
        return "ListDrinksFood";
    }

    @GetMapping("/AdminPage/listMealsFood")
    public String listofMeals(Model model){
        List<Meals> meals = mealsRepo.findAll();
        model.addAttribute("foods",meals);
        return "ListMealsFood";
    }

    @GetMapping("/AdminPage/listDessertsFood")
    public String listofDesserts(Model model){
        List<Desserts> desserts = dessertsRepo.findAll();
        model.addAttribute("foods",desserts);
        return "ListDessertsFood";
    }

    @GetMapping("/AdminPage/listSnacksFood")
    public String listofSnacks(Model model){
        List<Snacks> snacks = snacksRepo.findAll();
        model.addAttribute("foods",snacks);
        return "ListSnacksFood";
    }

    @GetMapping("/AdminPage/listChefs")
    public String listofChefs(Model model){
        List<Chefs> chefs = chefsRepo.findAll();
        List<PositionChef>position = Arrays.asList(PositionChef.values());
        model.addAttribute("chefs",chefs);
        model.addAttribute("position",position);
        return "ListChefs";
    }

}

