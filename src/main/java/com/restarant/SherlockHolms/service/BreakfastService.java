package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Breakfast;
import com.restarant.SherlockHolms.repos.BreakfastRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class BreakfastService {
    @Value("${uploads.path}")
    private String uploadPath;

    private final BreakfastRepo breakfastRepo;

    public BreakfastService(BreakfastRepo breakfastRepo) {
        this.breakfastRepo = breakfastRepo;
    }


    public void saveFile(Breakfast breakfast,MultipartFile file) throws IOException {
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

    public Map<String, List<Breakfast>> cutMassiveontwohalf(List<Breakfast>massiveObject){
        Map<String,List<Breakfast>>massives = new HashMap<>();
        List<Breakfast>left = new ArrayList<>();
        List<Breakfast>right = new ArrayList<>();

        for (int i = 0; i <= massiveObject.size()/2 - 1 ; i++) {
            left.add(massiveObject.get(i));
        }


        for (int i = massiveObject.size()/2; i < massiveObject.size(); i++) {
            right.add(massiveObject.get(i));
        }

        massives.put("left",left);
        massives.put("right",right);


        return massives;
    }

    public boolean addBreakfast(String name_food, Integer cost_food, String describe_food, Breakfast breakfast) {
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);
        breakfastRepo.save(breakfast);
        return true;
    }

    public boolean editBreakfast(String name_food, Integer cost_food, String describe_food, Breakfast breakfast, MultipartFile file) throws IOException {
        breakfast.setName_food(name_food);
        breakfast.setCost_food(cost_food);
        breakfast.setDescribe_food(describe_food);
        saveFile(breakfast,file);
        breakfastRepo.save(breakfast);

        return true;
    }
}
