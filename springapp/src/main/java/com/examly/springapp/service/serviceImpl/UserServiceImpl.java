package com.examly.springapp.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    //NOT USING THIS ONE ANYMORE CHANGED IT IN AUTHCONTROLLER
    // @Override
    // public User loginUser(User user) {
    //     return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
    // }

    @Override
    public User getUserById(int userId) {
        Optional<User> ou = userRepo.findById(userId);
        if(ou.isEmpty()){
            return null;
        }
        return ou.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    
}
