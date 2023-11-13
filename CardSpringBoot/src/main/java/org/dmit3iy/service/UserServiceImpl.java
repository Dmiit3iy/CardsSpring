package org.dmit3iy.service;

import org.dmit3iy.model.User;
import org.dmit3iy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        try {
            user.setRegDate(LocalDate.now());
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("User has already added!");
        }
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User get(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User does not exists!"));
    }

    //    @Override
//    public User get(String login, String password) {
//        return this.get().stream().filter(x -> x.getLogin().equals(login)
//                && x.getPassword().equals(password)).collect(Collectors.toList()).get(0);
//    }

    @Override
    public User get(String login, String password) {
        return this.userRepository.findAllByLoginAndPassword(login, password);
    }


    @Override
    public User delete(long id) {
        User user = this.get(id);
        userRepository.deleteById(id);
        return user;
    }
}
