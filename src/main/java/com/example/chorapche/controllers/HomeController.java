package com.example.chorapche.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/product-details/{cardTitle}")
    public String processData(@PathVariable("cardTitle") String productName, HttpSession session) {
        // Store the card title in the session or process as needed
        session.setAttribute("productName", productName);

        // Redirect to another page to display the data
        return "redirect:/showData";
    }
}
