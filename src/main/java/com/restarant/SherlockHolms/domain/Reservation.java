package com.restarant.SherlockHolms.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Reservetion_Table")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String email;
    private String PhoneNumber;

    @ElementCollection(targetClass = CountofPeople.class, fetch = FetchType.EAGER)
    @CollectionTable(name="Count_of_People",joinColumns = @JoinColumn(name = "Cop_id"))
    @Enumerated(EnumType.STRING)
    private Set<CountofPeople> countofPeople;

    private Date dateReservation;

    private String message;

    public Reservation() { }


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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Set<CountofPeople> getCountofPeople() {
        return countofPeople;
    }

    public void setCountofPeople(Set<CountofPeople> countofPeople) {
        this.countofPeople = countofPeople;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
