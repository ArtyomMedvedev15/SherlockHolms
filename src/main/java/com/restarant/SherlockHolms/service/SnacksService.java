package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Snacks;
import com.restarant.SherlockHolms.repos.SnacksRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
public class SnacksService {
    @Value("${uploads.path}")
    private String uploadPath;

    private final SnacksRepo snacksRepo;

    public SnacksService(SnacksRepo snacksRepo) {
        this.snacksRepo = snacksRepo;
    }

    public void saveFile(Snacks snacks, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            snacks.setFilename(resultFileName);
        }
    }

    public boolean addSnack(String name_food, Integer cost_food, String describe_food, Snacks snacks) {
        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);
        snacksRepo.save(snacks);
        return true;

    }

    public boolean editSnack(String name_food, Integer cost_food, String describe_food, MultipartFile file, Snacks snacks) throws IOException {

        snacks.setName_food(name_food);
        snacks.setCost_food(cost_food);
        snacks.setDescribe_food(describe_food);
        saveFile(snacks, file);

        return true;
    }
}
