package com.example.ksmapi.repository.ingredient;

import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IngredientTransactionRepository extends JpaRepository<IngredientTransaction,String> {
    List<IngredientTransaction> findAllByIngredientId(String ingredientId);
    List<IngredientTransaction> findAllByEntryId(String entryId);
    List<IngredientTransaction> findAllByDate(LocalDate localDate);
    List<IngredientTransaction> findAllByOrderByDate();
}
