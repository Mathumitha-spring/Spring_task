package com.jwtdemo.repository;
import org.springframework.data.repository.CrudRepository;

import com.jwtdemo.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}