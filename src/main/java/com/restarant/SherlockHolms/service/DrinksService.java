package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Drinks;
import com.restarant.SherlockHolms.repos.DrinksRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class DrinksService {
    @Value("${uploads.path}")
    private String uploadPath;

    private final DrinksRepo drinksRepo;

    public DrinksService(DrinksRepo drinksRepo) {
        this.drinksRepo = drinksRepo;
    }

    public void saveFile(Drinks drinks, MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            drinks.setFilename(resultFileName);
        }
    }

    public boolean addDrinks(String name_food, Integer cost_food, String describe_food, Drinks drinks) {
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);
        drinksRepo.save(drinks);

        return true;
    }

    public boolean editDrinks(String name_food, Integer cost_food, String describe_food, MultipartFile file, Drinks drinks) throws IOException {
        drinks.setName_food(name_food);
        drinks.setCost_food(cost_food);
        drinks.setDescribe_food(describe_food);
        saveFile(drinks, file);

        drinksRepo.save(drinks);

        return true;
    }
}
