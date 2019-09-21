package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.repos.ReservationRepo;
import com.restarant.SherlockHolms.temp.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.*;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerServiceTest {
    private Department[]massDep = {
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan"),
            new Department(7, 3, "Japan")
    };

    private Department[]massDep2 = {
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    };
    @Autowired
    private MainControllerService mainControllerService;

    @MockBean
    private ReservationRepo reservationRepo;

    @Test
    public void addReservation() {
        boolean isAddReservation = mainControllerService.addReservation("Test","Test","1231231","OnePerson","Test");

        Assert.assertTrue(isAddReservation);
    }

    @Test
    public void convertStringtoDate() {
        String[]masDate = "09/15/2019".split("/");
        Date dateResult = new Date(Integer.parseInt(masDate[2])-1900,Integer.parseInt(masDate[0])-1,Integer.parseInt(masDate[1]));

        Assert.assertEquals(dateResult.toString(),"2019-09-15");
    }

    @Test
    public void cutMassiveontwohalf() {
        List<Object>massiveObject =Arrays.asList(massDep);
        Map<String, List<Object>> massives = new HashMap<>();
        List<Object>left = new ArrayList<>();
        List<Object>right = new ArrayList<>();

        for (int i = 0; i <= massiveObject.size()/2 - 1 ; i++) {
            left.add(massiveObject.get(i));
        }


        for (int i = massiveObject.size()/2; i < massiveObject.size(); i++) {
            right.add(massiveObject.get(i));
        }

        massives.put("left",left);
        massives.put("right",right);

        Assert.assertEquals(massives.get("left").size(),massives.get("right").size());

    }

    @Test
    public void cutMassiveontwohalf2() {
        List<Object>massiveObject =Arrays.asList(massDep2);
        Map<String, List<Object>> massives = new HashMap<>();
        List<Object>left = new ArrayList<>();
        List<Object>right = new ArrayList<>();

        for (int i = 0; i <= massiveObject.size()/2 - 1 ; i++) {
            left.add(massiveObject.get(i));
        }


        for (int i = massiveObject.size()/2; i < massiveObject.size(); i++) {
            right.add(massiveObject.get(i));
        }

        massives.put("left",left);
        massives.put("right",right);

        assertTrue(massives.get("right").size() > massives.get("left").size());

    }

}