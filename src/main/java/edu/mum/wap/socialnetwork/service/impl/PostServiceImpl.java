package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.impl.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.service.PostService;

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

    @Override
    public List<Post> getAllActiveFollowedPosts(User user) {
        List<Post> result = postRepository.findAllActiveRecentPosts();
//        result = result.stream()
//                .filter(post -> post.getUser().getFollowers().contains(user.getFollowers()))
        return null;
    }

    @Override
    public Post findPostById(int id) {
        return postRepository.findPostById(id);
    }
}
