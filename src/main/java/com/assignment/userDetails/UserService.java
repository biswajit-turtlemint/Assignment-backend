package com.assignment.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> allUser(){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }

    public Optional<User> findUserById(String Id){
        return userRepository.findById(Id);
    }
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public User addNewUser(User user){
       return userRepository.save(user);
    }

    public User updateUser(User user){
        return  userRepository.save(user);
    }
    public void deleteUserById(String Id){
        userRepository.deleteById(Id);
    }
}
