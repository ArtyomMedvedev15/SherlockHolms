package com.restarant.SherlockHolms.domain;

import javax.persistence.*;

@Entity
@Table(name = "Desserts_Table")
public class Desserts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_food;
    private Integer cost_food;
    private String describe_food;
    private String filename;

    public String getDescribe_food() {
        return describe_food;
    }

    public void setDescribe_food(String describe_food) {
        this.describe_food = describe_food;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Desserts() { }

    public Desserts(String name_food, Integer cost_food, String describe_food, String filename) {
        this.name_food = name_food;
        this.cost_food = cost_food;
        this.describe_food = describe_food;
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_food() {
        return name_food;
    }

    public void setName_food(String name_food) {
        this.name_food = name_food;
    }

    public Integer getCost_food() {
        return cost_food;
    }

    public void setCost_food(Integer cost_food) {
        this.cost_food = cost_food;
    }
}
