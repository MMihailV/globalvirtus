package com.jdriven.ng2boot.service;

import java.security.SecureRandom;
import java.util.List;

import com.jdriven.ng2boot.DAO.IUserDAO;
import com.jdriven.ng2boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

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
    public String getUserByLogin(String login, String password) {

        if (userDAO.userExists(login, password)) {
            return tokenGeneration();
        }
        else {
            return "";
        }
    }

    @Override
    public synchronized boolean createUser(String login, String email, String password){
        User user = new User();
        user.setId(null);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName("");
        user.setLastName("");
        user.setFK_Role(1L);

        if (userDAO.userExists(user)) {
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

    private String tokenGeneration() {
        int len = 21;
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}