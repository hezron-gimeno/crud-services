package com.example.Week1.domain;

import com.example.Week1.domain.enumeration.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

}
