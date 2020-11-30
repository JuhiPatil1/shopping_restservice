package com.application.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.shopping.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}


