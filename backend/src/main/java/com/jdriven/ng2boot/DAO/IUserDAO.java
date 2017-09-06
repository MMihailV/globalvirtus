package com.jdriven.ng2boot.DAO;

import com.jdriven.ng2boot.domain.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(Long id, String firstName, String lastName, String email, String login, String password, Long FK_Role);
    boolean userExists(String login, String password);
}