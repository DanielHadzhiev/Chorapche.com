package com.example.chorapche.service.impl;

import com.example.chorapche.model.entity.Product;
import com.example.chorapche.repos.ProductRepository;
import com.example.chorapche.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void initProducts() {
 if(!areProductsInit()){

     Product product1 =new Product("Чорапи с пица",
             "Забавни чорапи с принт на пица",
             5.99,
             "/images/pizza-main.jpg",
             20,8,14);
     Product product2 =new Product("Чорапи с донъти",
             "Забавни чорапи с принт на донъти",
             5.99,
             "/images/donuts-main.jpg",
             20,8,14);
     Product product3 = new Product("Чорапи с кока-кола",
             "Забавни чорапи с принт на кока-кола",
             5.99,
             "/images/colas-main.jpg",
             20,8,14);
     Product product4 = new Product("Чорапи с бургери",
             "Забавни чорапи с принт на бургери",
             5.99,
             "/images/burgers-main.jpg",
             20,8,14);
     Product product5 = new Product("Чорапи с картофки",
             "Забавни чорапи с принт на картофки",
             5.99,
             "/images/fries-main.jpg",
             20,8,14);
     Product product6 = new Product("Чорапи с намигващо емоджи",
             "Забавни чорапи с принт на емоджи",
             4.99,
             "/images/wink-main.jpg",
             18,8,9);
     Product product7 = new Product("Чорапи с кеш емоджи",
             "Забавни чорапи с принт на емоджи",
             4.99,
             "/images/cash-main.jpg",
             18,8,9);
     Product product8 = new Product("Чорапи с очи",
             "Забавни чорапи с принт на емоджи",
             4.99,
             "/images/eyes-main.jpg",
             18,8,9);
     Product product9 = new Product("Чорапи с плачещо емоджи",
             "Забавни чорапи с принт на емоджи",
             4.99,
             "/images/crying-main.jpg",
             18,8,9);
     Product product10 = new Product("Чорапи с тъжно емоджи",
             "Забавни чорапи с принт на емоджи",
             4.99,
             "/images/sad-main.jpg",
             18,8,9);


     this.productRepository.saveAll(List.of(product1,
             product2,
             product3,
             product4,
             product5,
             product6,
             product7,
             product8,
             product9,
             product10));

 }

    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return List.of();
        }
        Optional<List<Product>> products = this.productRepository.
                findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        return products.orElseGet(List::of);
    }

    @Override
    public Product getProductByName(String name) {
        return this.productRepository.getProductByName(name);
    }

    @Override
    public boolean isProductNameValid(String productName) {
        return productRepository.existsByName(productName);
    }


    private boolean areProductsInit(){
        return this.productRepository.count() > 0;
    }
}
