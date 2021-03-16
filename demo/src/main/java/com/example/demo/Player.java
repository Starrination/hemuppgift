package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String jersey; 
    private int age;
    
    public Player() {
       
    }

    public Player(String name, String jersey, int age) {
        this.name = name;   
        this.jersey = jersey;
        this.age = age; 
    }

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey (String jersey) {
        this.jersey = jersey;
    }    

}
