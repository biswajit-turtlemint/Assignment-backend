package com.assignment.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<List<User>>(userService.allUser(), HttpStatus.OK);
    }
    @GetMapping("/modify/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Optional<User>> getSingleUserById(@PathVariable String id){
        return new ResponseEntity<Optional<User>>(userService.findUserById(id), HttpStatus.OK);
    }
    @GetMapping("/user/{username}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username){
        return new ResponseEntity<Optional<User>>(userService.findUserByUsername(username), HttpStatus.OK);
    }
    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.addNewUser(user), HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUserById(userId);
    }
}
