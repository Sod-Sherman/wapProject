package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

public interface UserService {
    public abstract Integer login(User user);
    public abstract void updateProfile(User user);
    public abstract Boolean addUser(User user);
    public abstract Boolean addPost(User user, Post post);
    public abstract void deactivateUser(User user);
    public abstract void followUser(User currentUser, User followUser);
}
