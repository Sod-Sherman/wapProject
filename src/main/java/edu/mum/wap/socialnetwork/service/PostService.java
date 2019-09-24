package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;

import java.util.List;

public interface PostService {

    public abstract Post getEmptyPost();

    public abstract List<Post> getAllPosts();

    public abstract List<Post> getAllActiveFollowedPosts(User user);
}
