package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.repository.UserRepositoryImpl;
import edu.mum.wap.socialnetwork.service.UserService;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public Integer login(User user) {  //if username, password is correct then return 1, admin 2, incorrect null
        User tempUser = userRepository.findByUsername(user.getUsername());
        if(tempUser != null && tempUser.getPassword().equalsIgnoreCase(user.getUsername())){
            if(tempUser.getUsername().equalsIgnoreCase("admin")) return 2; // admin user
            return 1; // general user
        }
        return null; //mismatch password or username
    }

    @Override
    public void updateProfile(User user) {
        User tempUser = userRepository.findByUsername(user.getUsername());
        if(tempUser == null) return;
        if(!tempUser.getUsername().equalsIgnoreCase(user.getUsername()))
            tempUser.setUsername(user.getUsername());
        if(!tempUser.getPassword().equals(user.getPassword()))
            tempUser.setPassword(user.getPassword());
        if(!tempUser.getFirstName().equals(user.getFirstName()))
            tempUser.setFirstName(user.getFirstName());
        if(!tempUser.getLastName().equals(user.getLastName()))
            tempUser.setLastName(user.getLastName());
        if(!tempUser.getEmail().equalsIgnoreCase(user.getEmail()))
            tempUser.setEmail(user.getEmail());

    }

    @Override
    public Boolean addUser(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.saveUser(user);
            return true;
        }
        else
            return false;


    }

    @Override
    public Boolean addPost(User user, Post post) {



        return false;

    }

    @Override
    public void deactivateUser(User user) {
        userRepository.deactivateUser(user);
    }

    @Override
    public void followUser(User currentUser, User followUser) {
        if(currentUser == null || followUser == null) return;
        currentUser.getFollowers().add(followUser);
    }

}
