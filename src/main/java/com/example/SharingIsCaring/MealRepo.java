package com.example.SharingIsCaring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface MealRepo extends CrudRepository<Meal, Long>{




//    void delete(Optional<Meal> byId);
}


