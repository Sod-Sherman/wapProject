package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class UserRepositoryImpl implements UserRepository {
    private List<User> users;

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    private UserRepositoryImpl(){
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
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        deactivateUser(user);
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
}
