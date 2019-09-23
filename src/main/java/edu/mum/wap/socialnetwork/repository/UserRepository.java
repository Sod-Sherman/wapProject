package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.*;

import java.util.List;

public interface UserRepository{
    abstract User findByUserId(Integer Id);
    abstract User findByUsername(String username);
    abstract List<User> findAllUsers();
    abstract void saveUser(User user);
    abstract void deleteUser(User user);
    abstract void deactivateUser(User user);

}
