package com.example.chorapche.init;

import com.example.chorapche.service.ImagePathsService;
import com.example.chorapche.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {

    private final ProductService productService;
    private final ImagePathsService imagePathsService;

    @Autowired
    public DbInit(ProductService productService,
                  ImagePathsService imagePathsService) {
        this.productService = productService;
        this.imagePathsService=imagePathsService;
    }

    @Override
    public void run(String... args) {
        this.productService.initProducts();
        this.imagePathsService.initImagePaths();
    }
}
