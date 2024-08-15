package com.example.chorapche.service;

import com.example.chorapche.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


 void initProducts();

 List<Product> getAllProducts();

 List<Product> searchProducts(String query);

 Product getProductByName(String name);

 boolean isProductNameValid(String productName);
}
