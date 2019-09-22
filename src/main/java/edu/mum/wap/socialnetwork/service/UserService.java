package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

public interface UserService {
    public abstract User login(User user);
    public abstract void manageProfile(User user);
    public abstract Boolean addUser(User user);
    public abstract Boolean addPost(User user, Post post);
}
