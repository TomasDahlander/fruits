package com.example.fruits.repositories;

import com.example.fruits.models.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IfruitRepo extends CrudRepository<Fruit, Long> {

    List<Fruit> findByName(String name);

    List<Fruit> findByColor(String color);

    List<Fruit> findByNameAndColor(String name, String color);
}
