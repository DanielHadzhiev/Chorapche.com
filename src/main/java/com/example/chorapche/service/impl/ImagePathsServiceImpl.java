package com.example.chorapche.service.impl;

import com.example.chorapche.model.entity.ImagePath;
import com.example.chorapche.repos.ImagePathRepository;
import com.example.chorapche.repos.ProductRepository;
import com.example.chorapche.service.ImagePathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImagePathsServiceImpl implements ImagePathsService {

    private final ImagePathRepository imagePathRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ImagePathsServiceImpl(ImagePathRepository imagePathRepository,
                                 ProductRepository productRepository) {
        this.imagePathRepository = imagePathRepository;
        this.productRepository=productRepository;
    }

    @Override
    public void initImagePaths() {
        if(!areImagePathsInit()){

            ImagePath pizza1 = new ImagePath("/images/pizza-main.jpg",
                    this.productRepository.getReferenceById(1));
            ImagePath pizza2 = new ImagePath("/images/pizza-secondary.jpg",
                    this.productRepository.getReferenceById(1));
            ImagePath pizza3 = new ImagePath("/images/pizza-last.jpg",
                    this.productRepository.getReferenceById(1));

            ImagePath donuts1 =new ImagePath("/images/donuts-main.jpg",
                    this.productRepository.getReferenceById(2));
            ImagePath donuts2 = new ImagePath("/images/donuts-secondary.jpg",
            this.productRepository.getReferenceById(2));
            ImagePath donuts3 = new ImagePath("/images/donuts-last.jpg",
                    this.productRepository.getReferenceById(2));

            ImagePath colas1 =new ImagePath("/images/colas-main.jpg",
                    this.productRepository.getReferenceById(3));
            ImagePath colas2 = new ImagePath("/images/colas-secondary.jpg",
                    this.productRepository.getReferenceById(3));
            ImagePath colas3 = new ImagePath("/images/colas-last.jpg",
                    this.productRepository.getReferenceById(3));

            ImagePath burgers1 =new ImagePath("/images/burgers-main.jpg",
                    this.productRepository.getReferenceById(4));
            ImagePath burgers2 = new ImagePath("/images/burgers-secondary.jpg",
                    this.productRepository.getReferenceById(4));
            ImagePath burgers3 = new ImagePath("/images/burgers-last.jpg",
                    this.productRepository.getReferenceById(4));

            ImagePath fries1 =new ImagePath("/images/fries-main.jpg",
                    this.productRepository.getReferenceById(5));
            ImagePath fries2 = new ImagePath("/images/fries-secondary.jpg",
                    this.productRepository.getReferenceById(5));
            ImagePath fries3 = new ImagePath("/images/fries-last.jpg",
                    this.productRepository.getReferenceById(5));

            ImagePath wink1 =new ImagePath("/images/wink-main.jpg",
                    this.productRepository.getReferenceById(6));
            ImagePath wink2 = new ImagePath("/images/wink-secondary.jpg",
                    this.productRepository.getReferenceById(6));
            ImagePath wink3 = new ImagePath("/images/wink-last.jpg",
                    this.productRepository.getReferenceById(6));

            ImagePath cash1 =new ImagePath("/images/cash-main.jpg",
                    this.productRepository.getReferenceById(7));
            ImagePath cash2 = new ImagePath("/images/cash-secondary.jpg",
                    this.productRepository.getReferenceById(7));
            ImagePath cash3 = new ImagePath("/images/cash-last.jpg",
                    this.productRepository.getReferenceById(7));

            ImagePath eyes1 =new ImagePath("/images/eyes-main.jpg",
                    this.productRepository.getReferenceById(8));
            ImagePath eyes2 = new ImagePath("/images/eyes-secondary.jpg",
                    this.productRepository.getReferenceById(8));
            ImagePath eyes3 = new ImagePath("/images/eyes-last.jpg",
                    this.productRepository.getReferenceById(8));

            ImagePath crying1 =new ImagePath("/images/crying-main.jpg",
                    this.productRepository.getReferenceById(9));
            ImagePath crying2 = new ImagePath("/images/crying-secondary.jpg",
                    this.productRepository.getReferenceById(9));
            ImagePath crying3 = new ImagePath("/images/crying-last.jpg",
                    this.productRepository.getReferenceById(9));

            ImagePath sad1 =new ImagePath("/images/sad-main.jpg",
                    this.productRepository.getReferenceById(10));
            ImagePath sad2 = new ImagePath("/images/sad-secondary.jpg",
                    this.productRepository.getReferenceById(10));
            ImagePath sad3 = new ImagePath("/images/sad-last.jpg",
                    this.productRepository.getReferenceById(10));

            this.imagePathRepository.saveAll(List.of(pizza1,
                    pizza2,
                    pizza3,
                    donuts1,
                    donuts2,
                    donuts3,
                    colas1,
                    colas2,
                    colas3,
                    burgers1,
                    burgers2,
                    burgers3,
                    fries1,
                    fries2,
                    fries3,
                    wink1,
                    wink2,
                    wink3,
                    cash1,
                    cash2,
                    cash3,
                    eyes1,
                    eyes2,
                    eyes3,
                    crying1,
                    crying2,
                    crying3,
                    sad1,
                    sad2,
                    sad3));
        }
    }
    private boolean areImagePathsInit(){
        return this.imagePathRepository.count() > 0;
    }
}
