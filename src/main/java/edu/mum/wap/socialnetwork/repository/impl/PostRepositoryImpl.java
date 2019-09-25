package edu.mum.wap.socialnetwork.repository.impl;

import edu.mum.wap.socialnetwork.model.*;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.UserRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class PostRepositoryImpl implements PostRepository {
    private List<Post> posts;
    private static final PostRepositoryImpl INSTANCE = new PostRepositoryImpl();

    public static PostRepositoryImpl getInstance() {
        return INSTANCE;
    }

    private PostRepositoryImpl() {
        UserRepository userRepository = UserRepositoryImpl.getInstance();
        User sod = userRepository.findByUsername("sod");
        User tur = userRepository.findByUsername("tur");
        User puujgee = userRepository.findByUsername("puujgee");

        Post sodPost = new Post("JavaScript.com is a resource built by the Pluralsight team for the JavaScript community.\n" +
                "\n" +
                "Because JavaScript is a great language for coding beginners, we've gathered some of the best learning resources around and built a JavaScript course to help new developers get up and running.\n" +
                "\n" +
                "With the help of community members contributing content to the site, JavaScript.com aims to also keep more advanced developers up to date on news, frameworks, and libraries.",
                LocalDate.of(2019, 8, 30), "", sod);
        Post sodPost1 = new Post("The docuseries about my life and work is out today. I hope you’ll check it out on Netflix — and then read some of the stories that didn’t make the cut on my blog.",
                LocalDate.of(2019, 8, 31), "images/post/safe_image.jpg", sod);

        Post turPost = new Post("Today, one of the biggest challenges facing Alzheimer’s researchers is finding patients who can benefit from novel therapies before it’s too late. AI is showing a lot of promise in helping to detect Alzheimer’s far earlier than current methods. I'm eager to see how it could change how we better understand and fight the disease.",
                LocalDate.of(2019, 9, 10), "https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQCBV-qYsqZM5Hy7&w=540&h=282&url=https%3A%2F%2Fwww.statnews.com%2Fwp-content%2Fuploads%2F2019%2F08%2Fdom-brain-1024x576.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQAF-ZJxpLw_rgYI", tur);

        Post puujgeePost = new Post("Whenever I hear an idea for what we can do to keep global warming in check—whether it’s over a conference table or a cheeseburger—I always ask this question: “What’s your plan for steel?” I know it sounds like an odd thing to say, but it opens the door to an important subject.",
                LocalDate.of(2019, 9, 22), "https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQAl4W7u2Re62WqJ&w=540&h=282&url=https%3A%2F%2Fwww.gatesnotes.com%2F-%2Fmedia%2FImages%2FArticles%2FEnergy%2FA-question-to-ask-about-every-climate-plan%2Fenergy-manufacturing_2019_article-hero_1200px_v2.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQCGwLSvFlNlfwhe", puujgee);


        this.posts = new ArrayList<Post>(Arrays.asList(sodPost, turPost, puujgeePost, sodPost1));

        List<Post> sodPosts = sod.getPosts();
        sodPosts.add(sodPost);
        sodPosts.add(sodPost1);

        List<Post> turPosts = tur.getPosts();
        turPosts.add(turPost);

        List<Post> puujgeePosts = puujgee.getPosts();
        puujgeePosts.add(puujgeePost);

    }


    @Override
    public Post findPostById(Integer Id) {
        for (Post post : posts) {
            if (post.getId() == Id) return post;
        }
        return null;
    }

    @Override
    public List<Post> findRecentPostsByUsername(String username) {
        if (username == null) return null;
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (username.equalsIgnoreCase(post.getUser().getUsername()))
                result.add(post);
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public List<Post> findAllActiveFollowersRecentPosts(User user) {
        if (user == null) return null;
        List<Post> result = new ArrayList<>();
        for (Post p : findAllActiveRecentPosts()) {
            for (Integer i = 0; i < user.getFollowers().size(); i++) {
                if (p.getUser().getId() == user.getFollowers().get(i).getId() || p.getUser().getId()==user.getId())
                    result.add(p);
            }
        }
        return result;
    }

    @Override
    public List<Post> findAllActiveRecentPosts() {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getActive()) result.add(post);
        }
        Collections.sort(result);
        //System.out.println("Posts by ordered: = " + result);
        return result;
    }

    @Override
    public void addPost(User user, Post post) {
        if (user == null && post == null) return;
        if (post.getUser() == null) post.setUser(user);
        //post.setId(Math.random());
        List<Post> postList = user.getPosts();
        postList.add(post);
        user.setPosts(postList);
        posts.add(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return posts;
    }

    public Post getPostById(Integer id) {
        for (Post p : posts) {
            System.out.println("p = " + p);
            if (p.getId().equals(id))
                return p;
        }

        return null;
    }
}

