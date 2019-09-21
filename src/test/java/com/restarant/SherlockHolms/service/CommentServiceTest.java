package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.repos.CommentRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @MockBean
    private CommentRepo commentRepo;

    @Test
    public void saveComment() {

        boolean isCreateComment = commentService.saveComment("Test","Test","Test");

        Assert.assertTrue(isCreateComment);
    }
}