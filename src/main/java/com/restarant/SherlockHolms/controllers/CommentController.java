package com.restarant.SherlockHolms.controllers;

import com.restarant.SherlockHolms.domain.CommentVisitor;
import com.restarant.SherlockHolms.repos.CommentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

   private final CommentRepo commentRepo;

    public CommentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
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
        CommentVisitor commentVisitor = new CommentVisitor(name,email,comment,null);
        commentRepo.save(commentVisitor);
        return "Comment";
    }
}
