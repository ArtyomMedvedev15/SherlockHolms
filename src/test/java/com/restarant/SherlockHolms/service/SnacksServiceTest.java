package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Snacks;
import com.restarant.SherlockHolms.repos.SnacksRepo;
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
public class SnacksServiceTest {

    @Autowired
    private SnacksService snacksService;

    @MockBean
    private SnacksRepo snacksRepo;

    @Test
    public void addSnack() {
    boolean isAddedSnack = snacksService.addSnack("", 123, "",new Snacks());
        Assert.assertTrue(isAddedSnack);
    }

    @Test
    public void editSnacks() throws IOException {
        Snacks snacks = new Snacks("name",123,"Desc","filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        snacksService.editSnack(snacks.getName_food(),1234,snacks.getDescribe_food(),file,snacks);

        assertSame("Desc", snacks.getDescribe_food());
        assertEquals(1234, (int) snacks.getCost_food());

    }
}