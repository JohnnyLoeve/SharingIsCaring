package com.example.SharingIsCaring;

import jakarta.persistence.*;

@Entity
public class Meal {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id of meal
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private Double price;
    @Column(name="img")
    private String img;
    @Column(name="contact")
    private String contact;
    @Column(name="tag")
    private String tag;

    public Meal(){
    }
    public Meal(Long id, String name, String description, Double price, String contact, String tag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.contact = contact;
        this.img = img;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
