package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

import java.util.List;

public interface PostRepository {

    public abstract List<Post> findRecentPostsByUsername(String username);
    public abstract void addPost(User user, Post post);
    public abstract List<Post> findAllPosts();
}
