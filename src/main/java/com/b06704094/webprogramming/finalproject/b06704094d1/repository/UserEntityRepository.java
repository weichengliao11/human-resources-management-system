package com.b06704094.webprogramming.finalproject.b06704094d1.repository;

import com.b06704094.webprogramming.finalproject.b06704094d1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserEntityRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

}
