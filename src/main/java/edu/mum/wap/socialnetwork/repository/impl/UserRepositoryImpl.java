package edu.mum.wap.socialnetwork.repository.impl;

import edu.mum.wap.socialnetwork.model.*;
import edu.mum.wap.socialnetwork.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class UserRepositoryImpl implements UserRepository {
    private List<User> users;

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();

    public UserRepositoryImpl() {
        this.users = new ArrayList<User>(Arrays.asList(
                new User("Sodbileg", "Shirmen", "sod", "123", "s@mum.edu"),
                new User("Purevdemberel", "Byambatogtokh", "puujgee", "123", "p@mum.edu"),
                new User("Turtogtokh", "M.", "tur", "123", "t@mum.edu"),
                new User("Admin", "LastNameAdmin", "admin", "123", "a@mum.edu")));
    }

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public User findByUserId(Integer Id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
//            System.out.println(user);
            if (user.getUsername().equalsIgnoreCase(username)) return user;
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {

        return users;
    }

    @Override
    public void saveUser(User user) {
        User tUser = findByUsername(user.getUsername());
        deleteUser(tUser);
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        User tUser = findByUsername(user.getUsername());
        List<User> users1 = new ArrayList<>();
        for (User iUser : users) {
            if (!iUser.getUsername().equalsIgnoreCase(tUser.getUsername()))
                users1.add(iUser);
        }
        this.users = users1;
    }

    @Override
    public void deactivateUser(User user) {
        User tempUser = findByUsername(user.getUsername());
        if (tempUser == null) return;
        tempUser.setActive(false);
        saveUser(tempUser);

    }


    public List<User> getUsers() {
        return users;
    }

    public void addFollower(User follower, User followedUser) {
        if(isUserInList(follower, users) && isUserInList(followedUser, users)){
            List<User> followers = followedUser.getFollowers();
            if(!isUserInList(follower, followers))
                followers.add(follower);
        }
    }

    public void deleteFollower(User user, User followedUser){
        if(isUserInList(user, users) && isUserInList(followedUser, users)){
            List<User> newFollowers = null;
            for (User u: user.getFollowers()){
                if(!followedUser.getUsername().equalsIgnoreCase(u.getUsername()))
                    newFollowers.add(u);
            }
            user.setFollowers(newFollowers);
        }

    }

    private Boolean isUserInList(User user, List<User> userList) {
        for (User u : userList)
            if (u.getUsername().equalsIgnoreCase(user.getUsername()))
                return true;
        return false;
    }
}
