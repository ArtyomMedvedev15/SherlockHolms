package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Meals;
import com.restarant.SherlockHolms.repos.MealsRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class MealsService {
    @Value("${uploads.path}")
    private String uploadPath;

    private final MealsRepo mealsRepo;

    public MealsService(MealsRepo mealsRepo) {
        this.mealsRepo = mealsRepo;
    }

    public void saveFile(Meals meals,  MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            meals.setFilename(resultFileName);
        }
    }

    public boolean addMeals(Meals meals, String name_food, Integer cost_food, String describe_food) {
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);
        mealsRepo.save(meals);
        return true;
    }

    public boolean editMeals(String name_food, Integer cost_food, String describe_food, MultipartFile file, Meals meals) throws IOException {
        meals.setName_food(name_food);
        meals.setCost_food(cost_food);
        meals.setDescribe_food(describe_food);
        saveFile(meals, file);

        mealsRepo.save(meals);
    return true;
    }
}
