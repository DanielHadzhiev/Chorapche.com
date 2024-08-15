package com.example.chorapche.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/reviews")
    public String getReviews(){
        return "reviews";
    }
    @GetMapping("/privacy-policy")
    public String getPrivacyPolicy(){
        return "privacy-policy";
    }
    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }
    @GetMapping("/about-us")
    public String getAboutUs(){
        return "about-us";
    }




}
