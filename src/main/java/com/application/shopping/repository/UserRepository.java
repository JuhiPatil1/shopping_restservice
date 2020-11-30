package com.application.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.shopping.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
