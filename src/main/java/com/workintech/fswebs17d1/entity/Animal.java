package com.workintech.fswebs17d1.entity;

public class Animal {
    private int id;
    private String name;

    // Boş Constructor (Spring mekanizmaları ve JSON eşlemeleri için şarttır)
    public Animal() {
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter ve Setter Metotları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}