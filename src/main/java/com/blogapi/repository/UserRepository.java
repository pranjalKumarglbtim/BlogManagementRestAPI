package com.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapi.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}