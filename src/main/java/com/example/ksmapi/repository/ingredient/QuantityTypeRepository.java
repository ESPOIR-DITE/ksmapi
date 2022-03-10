package com.example.ksmapi.repository.ingredient;

import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.QuantityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityTypeRepository extends JpaRepository<QuantityType,String> {
}
