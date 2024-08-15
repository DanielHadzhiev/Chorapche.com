package com.example.chorapche.repos;

import com.example.chorapche.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllBy();

    Optional<List<Product>> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    Product getProductByName(String name);

    boolean existsByName(String name);
}
