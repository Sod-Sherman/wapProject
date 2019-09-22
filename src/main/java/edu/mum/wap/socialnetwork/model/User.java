package edu.mum.wap.socialnetwork.model;

import java.util.List;
import java.util.Objects;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    private String email;
    private Boolean active = true;

    private List<User> followers;
    private List<Post> posts;
    private String location;


}
