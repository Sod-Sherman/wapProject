package edu.mum.wap.socialnetwork.model;

import java.time.LocalDate;

public class Post implements Comparable<Post>{
    private Integer id;
    private String content;
    private Boolean active = true;
    private LocalDate postedDate = LocalDate.now();
    private String imgURL;
    private User user;

    public Post(String content, LocalDate postedDate, String imgURL, User user) {
        this.content = content;
        this.postedDate = postedDate;
        this.imgURL = imgURL;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Post o) {
        return getPostedDate().compareTo(o.getPostedDate());
    }


}
