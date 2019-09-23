package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

import java.util.List;

public interface UserService {
    public abstract Integer login(User user);
    public abstract boolean updateProfile(User user);
    public abstract Boolean addUser(User user);
    public abstract Boolean addPost(User user, Post post);
    public abstract void deactivateUser(User user);
    public abstract void followUser(User currentUser, User followUser);

    abstract List<Post> getPosts(User user);
    abstract List<Post> getAllPosts();
    abstract List<User> getAllUsers();
    abstract List<Post> getPostsFollower(User user);
    abstract User findByUsername(String username);
}
