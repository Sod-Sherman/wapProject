package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.*;

public interface UserRepository{
    abstract User findByUserId(Integer Id);
    abstract User findByUsername(String username);
    abstract void saveUser(User user);
    abstract void deleteUser(User user);
    abstract void deactivateUser(User user);

}
