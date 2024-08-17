package com.example.chorapche.controllers;


import com.example.chorapche.exceptions.NotFoundException;
import com.example.chorapche.model.dto.CartItemDTO;
import com.example.chorapche.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.chorapche.model.entity.Product;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @ModelAttribute(name = "cartItemDTO")
    public CartItemDTO cartItemDTOInit(){
        return new CartItemDTO();
    }

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all-products")
    public String getAllProducts(){
        return "products";
    }

    @GetMapping("/search-results")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<Product> products = this.productService.searchProducts(query);
        model.addAttribute("products", products);
        model.addAttribute("query", query);
        return "search-results";
    }

    @GetMapping("/product-details/{productName}")
    public String productDetails(@PathVariable("productName") String productName, Model model) {

        if(!this.productService.isProductNameValid(productName)){
            throw new NotFoundException("Page was not found");
        }
        Product product = this.productService.getProductByName(productName);

        model.addAttribute("productName", productName);
        model.addAttribute("productDescription",product.getDescription());
        model.addAttribute("productPrice",product.getPrice());
        model.addAttribute("width",product.getWidth());
        model.addAttribute("height",product.getHeight());
        model.addAttribute("length",product.getLength());
        model.addAttribute("image1",product.getMainImageUrl());
        model.addAttribute("image2",product.getImageUrls().get(1).getUrl());
        model.addAttribute("image3",product.getImageUrls().get(2).getUrl());

        return "view-product";
    }



}
