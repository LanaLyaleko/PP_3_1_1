package com.example.pp_3_1_1.crud.userDao;

import com.example.pp_3_1_1.crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void add (User user);
    User findUserById (int id);
    void delete (int id);
    User edit(User user);

    void updateUser(User user);
}