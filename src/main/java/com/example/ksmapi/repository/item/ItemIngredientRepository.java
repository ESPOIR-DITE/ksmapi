package com.example.ksmapi.repository.item;

import com.example.ksmapi.domain.item.ItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemIngredientRepository extends JpaRepository<ItemIngredient, String> {
    List<ItemIngredient> findAllByEntryId(String entryId);
    List<ItemIngredient> findAllByIngredientId(String entryId);
    List<ItemIngredient> findAllByOrderByQuantity();

}
