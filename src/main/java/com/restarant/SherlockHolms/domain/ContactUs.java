package com.restarant.SherlockHolms.domain;

import javax.persistence.*;

@Entity
@Table(name = "ContactForms")
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Email;
    private String Subject;
    private String message;

    public ContactUs() {
    }

    public ContactUs(String name, String email, String subject, String message) {
        Name = name;
        Email = email;
        Subject = subject;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
