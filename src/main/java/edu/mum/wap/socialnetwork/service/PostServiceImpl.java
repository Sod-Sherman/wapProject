package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.PostRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class PostServiceImpl implements PostService {
    PostRepository postRepository = PostRepositoryImpl.getInstance();


    @Override
    public Post getEmptyPost() {
        Post emptyPost = new Post("No Posts yet", LocalDate.now(),"",null);
        return emptyPost;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllPosts();
    }
}
