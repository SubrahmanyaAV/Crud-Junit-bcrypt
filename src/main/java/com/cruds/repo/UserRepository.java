package com.cruds.repo;

import org.springframework.data.repository.CrudRepository;

import com.cruds.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
