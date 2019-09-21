package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Breakfast;
import com.restarant.SherlockHolms.repos.BreakfastRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
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
@TestPropertySource("/application-test.properties")

public class BreakfastServiceTest {


    @MockBean
    private BreakfastRepo breakfastRepo;

    @Autowired
    private BreakfastService breakfastService;

    @Test
    public void saveFile() throws IOException {
        Breakfast breakfast = new Breakfast();
        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile =  new MockMultipartFile("test","ws.png","jpeg/png",contents);
        breakfastService.saveFile( breakfast, multipartFile);

        Assert.assertNotNull(breakfast.getFilename());
     }

    @Test
    public void addBreakfast() {
        boolean isAddedBreakfast = breakfastService.addBreakfast("",132,"",new Breakfast());
        Assert.assertTrue(isAddedBreakfast);
    }

    @Test
    public void editBreakfast() throws IOException {
        Breakfast breakfast = new Breakfast("name",123,"Desc","filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        breakfastService.editBreakfast(breakfast.getName_food(),1234,breakfast.getDescribe_food(),breakfast,file);

        assertSame("Desc", breakfast.getDescribe_food());
        assertEquals(1234, (int) breakfast.getCost_food());

    }
}