package com.jdriven.ng2boot.DAO;

import com.jdriven.ng2boot.domain.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByLogin(String login);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(User user);
    boolean userExists(String login, String password);
}