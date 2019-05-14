package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.*;
import com.restarant.SherlockHolms.repos.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminController {
    @Value("${upload.path}")
    private String uploadPath;

    private final BreakfastRepo breakfastRepo;

    private final DessertsRepo dessertsRepo;

    private final MealsRepo mealsRepo;

    private final DrinksRepo drinksRepo;

    private final ChefsRepo chefsRepo;

    private final ReservationRepo reservationRepo;

    private final SnacksRepo snacksRepo;

    private final ContactUsRepo contactUsRepo;


    public AdminController(BreakfastRepo breakfastRepo, DessertsRepo dessertsRepo, MealsRepo mealsRepo, DrinksRepo drinksRepo, ChefsRepo chefsRepo, ReservationRepo reservationRepo, SnacksRepo snacksRepo, ContactUsRepo contactUsRepo) {
        this.breakfastRepo = breakfastRepo;
        this.dessertsRepo = dessertsRepo;
        this.mealsRepo = mealsRepo;
        this.drinksRepo = drinksRepo;
        this.chefsRepo = chefsRepo;
        this.reservationRepo = reservationRepo;
        this.snacksRepo = snacksRepo;
        this.contactUsRepo = contactUsRepo;
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
        ){
        Breakfast breakfast = new Breakfast();
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);
        breakfast.setFilename(file.getOriginalFilename());

        breakfastRepo.save(breakfast);
     return "redirect:/AdminPage";
    }

    //Future functionallity :)
    private void saveFile(Breakfast breakfast, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            breakfast.setFilename(resultFileName);
        }
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
    ){
        Meals meals = new Meals();
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);
        meals.setFilename(file.getOriginalFilename());

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
    ){
        Snacks snacks = new Snacks();
        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);
        snacks.setFilename(file.getOriginalFilename());

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
    ){
        Desserts desserts = new Desserts();
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);
        desserts.setFilename(file.getOriginalFilename());

        dessertsRepo.save(desserts);
        return "redirect:/AdminPage";
    }

    @GetMapping("/AdminPage/addDrinks")
    public String addDrinksFood(){
        return "AddFoodDrinks";
    }

    @PostMapping("/AdminPage/addDesserts")
    public String addDrinksFood(
            @RequestParam(name = "name_food")String name_food,
            @RequestParam(name = "cost_food")Integer cost_food,
            @RequestParam(name = "describe_food")String describe_food,
            @RequestParam("file") MultipartFile file
    ){
        Drinks drinks = new Drinks();
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);
        drinks.setFilename(file.getOriginalFilename());

        drinksRepo.save(drinks);
        return "redirect:/AdminPage";
    }


}

