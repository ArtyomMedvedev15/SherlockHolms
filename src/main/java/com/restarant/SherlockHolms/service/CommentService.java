package com.restarant.SherlockHolms.service;

import com.restarant.SherlockHolms.domain.CommentVisitor;
import com.restarant.SherlockHolms.repos.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public boolean saveComment(String name, String email, String comment) {
        CommentVisitor commentVisitor = new CommentVisitor(name,email,comment,null);
        commentRepo.save(commentVisitor);
        return true;
    }
}
