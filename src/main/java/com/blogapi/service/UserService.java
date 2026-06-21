package com.blogapi.service;

import java.util.List;
import com.blogapi.model.entity.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}