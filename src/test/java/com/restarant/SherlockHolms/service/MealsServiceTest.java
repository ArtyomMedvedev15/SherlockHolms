package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Meals;
import com.restarant.SherlockHolms.repos.MealsRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MealsServiceTest {

    @MockBean
    private MealsRepo mealsRepo;

    @Autowired
    private MealsService mealsService;

    @Test
    public void addMeals() {
        boolean isAddedMeals = mealsService.addMeals(new Meals(),"",123,"");
    }
    @Test
    public void editMeals() throws IOException {

        Meals meals = new Meals("name",123,"Desc","filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        mealsService.editMeals(meals.getName_food(),1234,meals.getDescribe_food(),file,meals);

        assertSame("Desc", meals.getDescribe_food());
        assertEquals(1234, (int) meals.getCost_food());


    }
}