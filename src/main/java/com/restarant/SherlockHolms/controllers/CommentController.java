package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/Comment")
    public String comment(){
        return "Comment";
    }

    @PostMapping("/Comment")
    public String addComment(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "email")String email,
            @RequestParam(name = "message")String comment
    ){
        commentService.saveComment(name,email,comment);
        return "Comment";
    }
}
