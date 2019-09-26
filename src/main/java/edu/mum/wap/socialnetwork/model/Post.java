package edu.mum.wap.socialnetwork.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Post implements Comparable<Post> {
    private boolean health = true;
    private static final AtomicInteger uniqueId=new AtomicInteger();
    private final int id;
    private String content;
    private Boolean active = true;
    private LocalDate postedDate = LocalDate.now();
    private String imgUrl;
    private User user;


    public Post(String content, String imgURL, User user) {
        this.id = uniqueId.getAndIncrement();
        this.content = content;
        this.imgUrl = imgURL;
        this.user = user;
    }

    public Post(String content, LocalDate postedDate, String imgURL, User user) {
        this.id = uniqueId.getAndIncrement();
        this.content = content;
        this.postedDate = postedDate;
        this.imgUrl = imgURL;
        this.user = user;
    }

    public boolean isHealthy() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Post o) {
        return o.getPostedDate().compareTo(this.getPostedDate());
    }

    @Override
    public String toString() {
        return "Post{" +
                "health=" + health +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", active=" + active +
                ", postedDate=" + postedDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", user=" + user +
                '}';
    }
}
