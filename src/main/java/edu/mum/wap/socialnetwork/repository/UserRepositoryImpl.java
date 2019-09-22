package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.*;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<User> users;
    public UserRepositoryImpl(){
        this.users = new ArrayList<User>(Arrays.asList(
                new User("Sodbileg", "Shirmen", "sod", "123", "s@mum.edu"),
                new User("Purevdemberel", "Byambatogtokh", "puujgee","123", "p@mum.edu"),
                new User("Turtogtokh", "M.", "tur", "123", "t@mum.edu"),
                new User("Admin", "", "admin","123","a@mum.edu")
        ));
    }
    @Override
    public User findByUserId(Integer Id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        for(User user: users){
            if(user.getUsername().equalsIgnoreCase(username)) return user;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {

    }


}
