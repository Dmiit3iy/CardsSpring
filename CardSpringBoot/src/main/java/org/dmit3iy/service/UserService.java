package org.dmit3iy.service;

import org.dmit3iy.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> get();
    User get(long id);
    User get(String login, String password);
    User delete(long id);
}
