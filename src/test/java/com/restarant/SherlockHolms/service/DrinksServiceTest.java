package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Drinks;
import com.restarant.SherlockHolms.repos.DrinksRepo;
import org.junit.Assert;
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
public class DrinksServiceTest {

    @MockBean
    private DrinksService drinksService;

    @Autowired
    private DrinksRepo drinksRepo;
    @Test
    public void addDrinks() {
        boolean isAddedDrinks = drinksService.addDrinks("" ,123,"",new Drinks());

        Assert.assertTrue(isAddedDrinks);
    }
    @Test
    public void editDrinks() throws IOException {
        Drinks drinks = new Drinks("name",123,"Desc","filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        drinksService.editDrinks(drinks.getName_food(),1234,drinks.getDescribe_food(),file,drinks);

        assertSame("Desc", drinks.getDescribe_food());
        assertEquals(1234, (int) drinks.getCost_food());
    }

}