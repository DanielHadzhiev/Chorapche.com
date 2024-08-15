package com.example.chorapche.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    public Order() {
        this.cartItems =new ArrayList<>();
    }

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

@Column(name = "first_second_name"
        ,nullable = false)
    private String FirstSecondName;

@Column(name = "address"
        ,nullable = false
        ,columnDefinition = "TEXT")
    private String address;

@Column(name = "email")
    private String email;

@Column(name = "phone_number")
private String phoneNumber;

@OneToMany()
 private List<CartItem> cartItems;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstSecondName() {
        return FirstSecondName;
    }

    public void setFirstSecondName(String firstSecondName) {
        FirstSecondName = firstSecondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
