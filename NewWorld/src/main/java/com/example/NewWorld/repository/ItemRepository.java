package com.example.NewWorld.repository;

import com.example.NewWorld.entity.Category;
import com.example.NewWorld.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items,Integer>{
    List<Items> findByCategory(Category category);
}
