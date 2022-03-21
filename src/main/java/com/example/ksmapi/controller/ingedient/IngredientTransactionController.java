package com.example.ksmapi.controller.ingedient;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.ingredient.Ingredient;
import com.example.ksmapi.domain.ingredient.IngredientTransaction;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public interface IngredientTransactionController extends ControllerInterface<IngredientTransaction,String> {
    ResponseEntity<List<IngredientTransaction>> findAllByIngredientId(String ingredientId, HttpServletRequest request);
    ResponseEntity<List<IngredientTransaction>> findAllByEntryId(String entryId, HttpServletRequest request);
    ResponseEntity<List<IngredientTransaction>> findAllByDate(LocalDate localDate, HttpServletRequest request);
    ResponseEntity<List<IngredientTransaction>> findAllByOrderByDate(HttpServletRequest request);
    ResponseEntity<List<IngredientTransaction>> findAllByTransactionId(String transactionId, HttpServletRequest request);
    ResponseEntity<Boolean> deleteByTransactionIdAndIngredientId(String transactionId, String IngredientId, HttpServletRequest request);
    ResponseEntity<IngredientTransaction> readByIngredientId(String ingredientId,HttpServletRequest request);
}
