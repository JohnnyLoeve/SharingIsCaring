package com.example.SharingIsCaring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MealRepo extends CrudRepository<Meal, Long>{
    @Query(value ="SELECT id, name, description, price, img, contact, tag FROM Meal WHERE tag = ?1", nativeQuery = true)
    List<Meal> sort(
            String cat

    );

//    void delete(Optional<Meal> byId);
}


