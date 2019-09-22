package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    private UserRepository userRepository;
    private List<Post> posts;

    public PostRepositoryImpl() {
        if(posts == null)
            posts = new ArrayList<>(Arrays.asList(
                new Post("The docuseries about my life and work is out today. I hope you’ll check it out on Netflix — and then read some of the stories that didn’t make the cut on my blog.",
                        LocalDate.of(2019,8,31),"/images/post/safe_image.jpg",
                        userRepository.findByUsername("sod")),
                new Post("Today, one of the biggest challenges facing Alzheimer’s researchers is finding patients who can benefit from novel therapies before it’s too late. AI is showing a lot of promise in helping to detect Alzheimer’s far earlier than current methods. I'm eager to see how it could change how we better understand and fight the disease.",
                        LocalDate.of(2019,9,10),"https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQCBV-qYsqZM5Hy7&w=540&h=282&url=https%3A%2F%2Fwww.statnews.com%2Fwp-content%2Fuploads%2F2019%2F08%2Fdom-brain-1024x576.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQAF-ZJxpLw_rgYI",
                        userRepository.findByUsername("tor")),
                new Post("Whenever I hear an idea for what we can do to keep global warming in check—whether it’s over a conference table or a cheeseburger—I always ask this question: “What’s your plan for steel?” I know it sounds like an odd thing to say, but it opens the door to an important subject.",
                        LocalDate.of(2019,9,22),"https://external-ort2-1.xx.fbcdn.net/safe_image.php?d=AQAl4W7u2Re62WqJ&w=540&h=282&url=https%3A%2F%2Fwww.gatesnotes.com%2F-%2Fmedia%2FImages%2FArticles%2FEnergy%2FA-question-to-ask-about-every-climate-plan%2Fenergy-manufacturing_2019_article-hero_1200px_v2.jpg&cfs=1&upscale=1&fallback=news_d_placeholder_publisher&_nc_hash=AQCGwLSvFlNlfwhe",
                        userRepository.findByUsername("puujgee"))));
    }

    @Override
    public List<Post> findRecentPostsByUsername(String username) {
        if(username == null) return null;
        List<Post> result = new ArrayList<>();
        for(Post post: posts){
            if(username.equalsIgnoreCase(post.getUser().getUsername()))
                result.add(post);
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public void addPost(User user, Post post) {
        if(user == null && post == null) return;
        if(post.getUser() == null) post.setUser(user);
        posts.add(post);
    }
}
