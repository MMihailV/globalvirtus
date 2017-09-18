package com.jdriven.ng2boot.service;

import java.util.List;

import com.jdriven.ng2boot.DAO.IUserDAO;
import com.jdriven.ng2boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User getUserById(int userId) {
        User obj = userDAO.getUserById(userId);
        return obj;
    }

    @Override
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    @Override
    public boolean getUserByLogin(String login, String password) {

        if (userDAO.userExists(login, password)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public synchronized boolean createUser(User user){
        if (userDAO.userExists(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getLogin(), user.getPassword(), user.getFK_Role())) {
            return false;
        } else {
            userDAO.createUser(user);
            return true;
        }
    }
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}