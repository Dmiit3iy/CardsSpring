package org.dmit3iy.repository;

import org.dmit3iy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findAllByLoginAndPassword(String login, String password);
    

}
