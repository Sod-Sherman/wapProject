package edu.mum.wap.socialnetwork.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger uniqueId=new AtomicInteger();
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String fullName;
    private LocalDate dob;
    private String imgUrl;
    private String twitter;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    private String email;
    private Boolean active = true;

    private List<User> followers =  new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private String location;
    private String phone;


    public User() {
    }

    //Puujgee Constructor
    public User(String firstName, String lastName, String password, String email, String location, String phone) {
        this.id = uniqueId.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }

    public User(String firstName, String lastName, String username, String password, String email) {
        this.id = uniqueId.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.followers =  new ArrayList<>();
        this.posts  = new ArrayList<>();
        this.fullName = firstName + " " + lastName;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean validate(){
        return "admin".equals(password);

    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getFullName(){
        return fullName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", imgUrl='" + imgUrl + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
