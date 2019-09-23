package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.repository.UserRepositoryImpl;
import edu.mum.wap.socialnetwork.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserRepository userRepository = UserRepositoryImpl.getInstance();
    private PostRepository postRepository = PostRepositoryImpl.getInstance();

    @Override
    public Integer login(User user) {  //if username, password is correct then return 1, admin 2, incorrect null
        User tempUser = userRepository.findByUsername(user.getUsername());
        if (tempUser != null && tempUser.getPassword().equals(user.getPassword())) {
            if (tempUser.getUsername().equalsIgnoreCase("admin")) return 2; // admin user
            if(tempUser.getUsername().equalsIgnoreCase(user.getUsername()))    return 1; // general user
        }
        return 0; //mismatch password or username
    }

    @Override
    public void updateProfile(User user) {
        User tempUser = userRepository.findByUsername(user.getUsername());
        if (tempUser == null) return;
        if (!tempUser.getUsername().equalsIgnoreCase(user.getUsername()))
            tempUser.setUsername(user.getUsername());
        if (!tempUser.getPassword().equals(user.getPassword()))
            tempUser.setPassword(user.getPassword());
        if (!tempUser.getFirstName().equals(user.getFirstName()))
            tempUser.setFirstName(user.getFirstName());
        if (!tempUser.getLastName().equals(user.getLastName()))
            tempUser.setLastName(user.getLastName());
        if (!tempUser.getEmail().equalsIgnoreCase(user.getEmail()))
            tempUser.setEmail(user.getEmail());

    }

    @Override
    public Boolean addUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.saveUser(user);
            return true;
        } else
            return false;


    }

    @Override
    public Boolean addPost(User user, Post post) {
        // ToDo


        return false;

    }

    @Override
    public void deactivateUser(User user)
    {
        userRepository.deactivateUser(user);
    }

    @Override
    public void followUser(User currentUser, User followUser) {
        if (currentUser == null || followUser == null) return;
        currentUser.getFollowers().add(followUser);
    }

    @Override
    public List<Post> getPosts(User user) {
        return user.getPosts();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllPosts();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public List<Post> getPostsFollower(User user) {
        if(user == null) return null;
        return postRepository.findRecentPostsByUsername(user.getUsername());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
