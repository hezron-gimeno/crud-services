package com.example.Week1.repository;

import com.example.Week1.domain.User;
import com.example.Week1.domain.enumeration.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
     public User findByUsername(String username);
   //  public User findByEmployeeRole(String role);
     public Iterable<User> findByRole(Role role);
}
