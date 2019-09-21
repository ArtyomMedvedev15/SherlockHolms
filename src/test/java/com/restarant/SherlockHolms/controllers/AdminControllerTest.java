package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.repos.*;
import com.restarant.SherlockHolms.service.DessertsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class AdminControllerTest {

    @MockBean
    private BreakfastRepo breakfastRepo;

    @MockBean
    private DessertsRepo dessertsRepo;

    @MockBean
    private DrinksRepo drinksRepo;

    @MockBean
    private MealsRepo mealsRepo;

    @MockBean
    private SnacksRepo snacksRepo;

    @MockBean
    private ChefsRepo chefsRepo;

    @MockBean
    private ReservationRepo reservationRepo;

    @MockBean
    private CommentRepo commentRepo;

    @MockBean
    private ContactUsRepo contactUsRepo;

    @Autowired
    private DessertsService dessertsService;

    @Test
    public void listofBreakfast() {
        Assert.assertNotNull(breakfastRepo.findAll());

    }

    @Test
    public void listofDrinks() {
        Assert.assertNotNull(drinksRepo.findAll());

    }

    @Test
    public void listofMeals() {
        Assert.assertNotNull(mealsRepo.findAll());
    }

    @Test
    public void listofDesserts() {
        Assert.assertNotNull(dessertsRepo.findAll());
    }

    @Test
    public void listofSnacks() {
        Assert.assertNotNull(snacksRepo.findAll());
    }

    @Test
    public void listofChefs() {
        Assert.assertNotNull(chefsRepo.findAll());
    }

    @Test
    public void listReservation() {
        Assert.assertNotNull(reservationRepo.findAll());
    }

    @Test
    public void listContacts() {
        Assert.assertNotNull(contactUsRepo.findAll());
    }

    @Test
    public void listComment() {
        Assert.assertNotNull(commentRepo.findAll());
    }




}