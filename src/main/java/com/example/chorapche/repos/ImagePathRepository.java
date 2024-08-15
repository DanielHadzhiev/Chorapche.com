package com.example.chorapche.repos;

import com.example.chorapche.model.entity.ImagePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagePathRepository extends JpaRepository<ImagePath,Integer> {
}
