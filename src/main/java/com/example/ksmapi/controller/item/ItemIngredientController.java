package com.example.ksmapi.controller.item;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.item.ItemIngredient;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ItemIngredientController extends ControllerInterface<ItemIngredient,String> {
    ResponseEntity<List<ItemIngredient>> findAllByEntryId(String entryId, HttpServletRequest request);
    ResponseEntity<List<ItemIngredient>> findAllByIngredientId(String entryId, HttpServletRequest request);
    ResponseEntity<List<ItemIngredient>> findAllByOrderByQuantity(HttpServletRequest request);
}
