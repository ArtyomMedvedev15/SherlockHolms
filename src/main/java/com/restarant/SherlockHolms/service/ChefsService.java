package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Chefs;
import com.restarant.SherlockHolms.domain.PositionChef;
import com.restarant.SherlockHolms.repos.ChefsRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class ChefsService {

    private final ChefsRepo chefsRepo;

    @Value("${uploads.path}")
    private String uploadPath;

    public ChefsService(ChefsRepo chefsRepo) {
        this.chefsRepo = chefsRepo;
    }

    public void saveFile(Chefs chefs, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            chefs.setFilenameAvatarChefs(resultFileName);
        }
    }

    public boolean addChefs(String fullName, String position, Chefs chefs) {
        chefs.setFullName(fullName);

        Set<PositionChef> chefSet = new HashSet<>();
        chefSet.add(PositionChef.valueOf(position));
        chefs.setPositionChefs(chefSet);

        chefsRepo.save(chefs);
        return true;

    }

    public boolean editChefs(String fullName, String position, MultipartFile file, Chefs chef) throws IOException {
        chef.setFullName(fullName);
        Set<PositionChef> chefSet = new HashSet<>();
        chefSet.add(PositionChef.valueOf(position));
        chef.setPositionChefs(chefSet);
        saveFile(chef, file);

        chefsRepo.save(chef);

        return true;
    }
}
