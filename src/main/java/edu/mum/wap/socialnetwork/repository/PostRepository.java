package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

import java.util.List;

public interface PostRepository {

    public List<Post> findRecentPostsByUsername(String username);
    public void addPost(User user, Post post);
}
