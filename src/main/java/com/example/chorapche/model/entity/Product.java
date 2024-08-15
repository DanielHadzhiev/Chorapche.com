package com.example.chorapche.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    public Product() {
    }

    public Product(String name,
                   String description,
                   double price,
                   String mainImageUrl,
                   double length,
                   double width,
                   double height) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.mainImageUrl=mainImageUrl;
        this.length = length;
        this.width = width;
        this.height = height;
        this.imageUrls=new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Column(name = "name",unique = true,nullable = false)
    private String name;

   @Column(name = "description",nullable = false)
    private String description;

   @Column(name = "price",nullable = false)
    private double price;


    @Column(name = "main_image_url",nullable = false)
   private String mainImageUrl;

    @Column(name = "length",nullable = false)
    private double length;

    @Column(name = "width",nullable = false)
    private double width;

    @Column(name="height",nullable = false)
    private double height;

   @OneToMany(fetch = FetchType.EAGER,
           targetEntity = ImagePath.class,
           mappedBy = "product")
    private List<ImagePath> imageUrls;


    public long getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ImagePath> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ImagePath> imageUrls) {
        this.imageUrls = imageUrls;
    }
    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
