package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Desserts;
import com.restarant.SherlockHolms.repos.DessertsRepo;
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
public class DessertsServiceTest {

    @MockBean
    private DessertsRepo dessertsRepo;

    @Autowired
    private DessertsService dessertsService;
    @Test
    public void addDessert() {
        boolean isAddedDes = dessertsService.addDessert("",123,"",new Desserts());

        Assert.assertTrue(isAddedDes);

    }

    @Test
    public void editDesserts() throws IOException {
        Desserts desserts = new Desserts("name",123,"Desc","filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        dessertsService.editDessert(desserts.getName_food(),1234,desserts.getDescribe_food(),file,desserts);

        assertSame("Desc", desserts.getDescribe_food());
        assertEquals(1234, (int) desserts.getCost_food());
    }
}