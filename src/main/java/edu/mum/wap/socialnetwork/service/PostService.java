package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;

import java.util.List;

public interface PostService {

    public abstract Post getEmptyPost();

    public abstract List<Post> getAllPosts();
}
