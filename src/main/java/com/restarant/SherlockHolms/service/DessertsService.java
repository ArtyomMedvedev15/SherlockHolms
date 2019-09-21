package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Desserts;
import com.restarant.SherlockHolms.repos.DessertsRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class DessertsService {
    @Value("${uploads.path}")
    private String uploadPath;

    private final DessertsRepo dessertsRepo;

    public DessertsService(DessertsRepo dessertsRepo) {
        this.dessertsRepo = dessertsRepo;
    }

    public void saveFile(Desserts desserts,   MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            desserts.setFilename(resultFileName);
        }
    }

    public boolean addDessert(String name_food, Integer cost_food, String describe_food, Desserts desserts) {
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);
        dessertsRepo.save(desserts);
        return true;
    }

    public boolean editDessert(String name_food, Integer cost_food, String describe_food, MultipartFile file, Desserts desserts) throws IOException {
        desserts.setName_food(name_food);
        desserts.setCost_food(cost_food);
        desserts.setDescribe_food(describe_food);
        saveFile(desserts, file);

        dessertsRepo.save(desserts);

        return true;
    }
}
