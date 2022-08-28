package com.example.pp_3_1_1.crud.userService;

import com.example.pp_3_1_1.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add (User user);
    void delete (int id);
    void edit(User user);
    User getUserById(int id);
    void updateUser(User user);

}