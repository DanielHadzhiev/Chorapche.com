package com.example.chorapche.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_urls")
public class ImagePath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public ImagePath(String url,Product product) {
        this.url = url;
        this.product = product;
    }

    @Column(name = "urls")
    private String url;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    private Product product;

    public ImagePath() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
