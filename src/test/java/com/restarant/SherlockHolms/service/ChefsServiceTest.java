package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.Chefs;
import com.restarant.SherlockHolms.domain.PositionChef;
import com.restarant.SherlockHolms.repos.ChefsRepo;
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
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChefsServiceTest {

    @MockBean
    private ChefsRepo chefsRepo;

    @Autowired
    private ChefsService chefsService;

    @Test
    public void addChefs() {
        boolean isAddedChefs = chefsService.addChefs("", "Burger",new Chefs());

        Assert.assertTrue(isAddedChefs);
    }

    @Test
    public void editChef() throws IOException {
        Set<PositionChef> positionChefSet = new HashSet<>();
        positionChefSet.add(PositionChef.Burger);
        Chefs chefs = new Chefs("name",positionChefSet,"filename");

        Path path = Paths.get("D:/Project/RestranSherlokHolms/SherloskHolms/uploads/ws.png");
        byte[]contents = null;
        try {
            contents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file =  new MockMultipartFile("test","ws.png","jpeg/png",contents);

        chefsService.editChefs(chefs.getFullName(),PositionChef.Burger.name(),file,chefs);

        assertSame("name", chefs.getFullName());

    }
}