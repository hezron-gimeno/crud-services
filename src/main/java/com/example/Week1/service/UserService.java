package com.example.Week1.service;

import com.example.Week1.domain.User;
import com.example.Week1.domain.enumeration.Role;
import com.example.Week1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j

public class UserService {
    private final UserRepository userRepository;

     public UserService(UserRepository userRepository){
         this.userRepository = userRepository;
     }


//     Request to save a user
    public User saveUser(User user){
         log.info("Request to save a user");
         return userRepository.save(user);
    }
//read all users from the database
    public List<User> getUsers(){
         //create an empty list where all users will be added
        List<User> userList = new ArrayList<>();

        Iterable<User> userIterable= userRepository.findAll();
        for (User user:userIterable){
            userList.add(user);
        }
        return userList;

    }

    //update a user

    public User updateUser(Long id){
         log.info("Request to update user with id: {}", id);
         Optional<User> userOptional = userRepository.findById(id);

         if (userOptional.isEmpty()){
             log.info("User id does not exist");
             return null;
         }
         else{
             //create a new instance of user
             User user = userOptional.get();
             return userRepository.save(user);
         }

    }

    //delete user
    public void deleteUser(Long id){
        log.info("Request to delete user with id: {}", id);
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()){
            log.info("User id does not exist");
        }
        else{
           userRepository.deleteById(id);
        }
    }

//    retrieving a user by an email
    public Optional<User> findUserByEmail(String email){
         log.info("request to retrieve user");
         Optional<User> optionalUser = findUserByEmail(email);
         return optionalUser;
    }


//    retrieve user by id
    public Optional<User> findUserById(Long id){
         log.info("request to retrieve user with id");
         Optional<User> optionalUser= userRepository.findById(id);
         return optionalUser;
    }
    //method to find user by username
    public User findUsername(String username){
         return userRepository.findByUsername(username);
    }


    //retrieve all users by role

    public List<User> getAllUsersByRole(String role){
        //create an empty list where all users will be added
        List<User> userList = new ArrayList<>();
        Role userRole = Role.valueOf(role.toUpperCase());
        Iterable<User> userIterable= userRepository.findByRole(userRole);
        for (User user:userIterable){
            userList.add(user);
        }
        return userList;

    }

//    public User findByRole(String role){
//        return userRepository.findByEmployeeRole(role);
//    }


//    deleting a user
//    public void deleteUser(Long id){
//         log.info("Request to delete a user:");
//         userRepository.deleteById(id);
//    }


//    updating user credentials

}
