package com.example.fruits.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruit {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String color;

    public Fruit(){}

    public Fruit(String name) {
        this.id = id;
        this.name = name;
        this.color = "Vit";
    }

    public Fruit(String name, String color) {
        this.id = id;
        this.name = name;
    }

    public Fruit(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{ id: " + id + " | name: " + name + " | color: " + color + "}";
    }
}
