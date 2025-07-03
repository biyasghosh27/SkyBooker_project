package com.examly.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
//THIS METHOD IS NOT USED ANYMORE AS SERVICE IS NOT USED ANYMORE FOR THIS LOGIC
// DIRECTLY IN CONTROLLER IT IS USED
    // User findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
