package com.restarant.SherlockHolms.repos;

import com.restarant.SherlockHolms.domain.CommentVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentVisitor,Long> {
}
