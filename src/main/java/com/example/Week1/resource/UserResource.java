package com.example.Week1.resource;


import com.example.Week1.domain.User;
import com.example.Week1.domain.enumeration.Role;
import com.example.Week1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;
    public UserResource(UserService userService){
        this.userService = userService;
    }
//    saving a user
    @PostMapping("/add-user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        log.info("request to save a user : {}", user);
        userService.saveUser(user);
        return ResponseEntity.ok().body("User created successfully");
    }

    //Read users
    @GetMapping("/get-all-users")
    public List<User> getUsers(){
        log.info("Rest request to fetch all users");
        return userService.getUsers();
    }

    //update user
    @PutMapping("/update/user/{id}")
    public User updateUser(@PathVariable Long id){
        return userService.updateUser(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public  void deleteUser(@PathVariable Long id){
        log.info("request to delete a user with id : {}", id);
        userService.deleteUser(id);
    }

    //find by role
    @GetMapping("/find-by-role")
    public List<User> finByRole(@RequestParam("q") String role){
        log.info("Request to find all users by role : {}", role);
        return userService.getAllUsersByRole(role);
    }
//    @GetMapping("/get-user")
//    public Optional<User> findUserByEmail(String email){
//        log.info("finding user by email");
//        return userService.findUserByEmail(email);
//    }
//
//    @GetMapping("/get-user by id")
//    public Optional<User> findUserById(){
//        log.info("Request to save `get user with id");
//        return userService.findUserById(Id);
//    }
//
//    @PutMapping("/update-user")
//    public User updateUser(User user){
//        log.info("Request to update a user : {}");
//
//        return userService.UpdateUser(User);
//
//    }
//
//    @PutMapping("/update-user")
//    public User updateUser(User user){
//        log.info("Request to update a user : {}");
//        return userService.UpdateUser(User);
//
//    }


}