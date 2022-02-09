package com.example.ksmapi.repository.ingredient;

import com.example.ksmapi.domain.ingredient.IngredientEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IngredientEntryRepository extends JpaRepository<IngredientEntry,String> {
    List<IngredientEntry> findAllByIngredientId(String ingredientId);
    List<IngredientEntry> findAllByEntryId(String entryId);
    List<IngredientEntry> findAllByDate(LocalDate localDate);
    List<IngredientEntry> findAllByOrderByDate();
}
