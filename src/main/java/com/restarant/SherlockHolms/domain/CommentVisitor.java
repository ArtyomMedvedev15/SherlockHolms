package com.restarant.SherlockHolms.domain;

import javax.persistence.*;

@Entity
@Table(name = "Comment_Table")
public class CommentVisitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String NameVisitor;

    private String emailVisitor;

    private String commentVisitor;

    private Integer RatingVisitor;

    public CommentVisitor() {
    }

    public CommentVisitor(String nameVisitor, String emailVisitor, String commentVisitor, Integer ratingVisitor) {
        NameVisitor = nameVisitor;
        this.emailVisitor = emailVisitor;
        this.commentVisitor = commentVisitor;
        RatingVisitor = ratingVisitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameVisitor() {
        return NameVisitor;
    }

    public void setNameVisitor(String nameVisitor) {
        NameVisitor = nameVisitor;
    }

    public String getEmailVisitor() {
        return emailVisitor;
    }

    public void setEmailVisitor(String emailVisitor) {
        this.emailVisitor = emailVisitor;
    }

    public String getCommentVisitor() {
        return commentVisitor;
    }

    public void setCommentVisitor(String commentVisitor) {
        this.commentVisitor = commentVisitor;
    }

    public Integer getRatingVisitor() {
        return RatingVisitor;
    }

    public void setRatingVisitor(Integer ratingVisitor) {
        RatingVisitor = ratingVisitor;
    }
}
