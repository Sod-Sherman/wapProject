package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

import java.util.List;

public interface PostRepository {
    public abstract Post findPostById(Integer id);
    public abstract List<Post> findRecentPostsByUsername(String username);
    public abstract List<Post> findAllActiveRecentPosts();
    public abstract void addPost(User user, Post post);
    public abstract List<Post> findAllPosts();
    public abstract List<Post> findAllActiveFollowersRecentPosts(User user);
    public abstract List<Post> getHealthyPosts();
    public abstract boolean checkHealth(Post post);
}
