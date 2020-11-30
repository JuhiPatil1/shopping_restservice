package com.application.shopping.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.shopping.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

}
