package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.repository.UserRepositoryImpl;
import edu.mum.wap.socialnetwork.service.UserService;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User login(User user) {  //if user is exist then return user object or null
        return userRepository.findByUsername(user.getUsername());

    }

    @Override
    public void manageProfile(User user) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addPost(User user, Post post) {

    }

}
