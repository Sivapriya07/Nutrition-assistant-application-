package com.exercise.process.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user_detail")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "enter a name with minimum of 3 characters and maximum of 20 characters")
    private String name;

    @Column(name = "email")
    @NotBlank(message = "email should not be blank")
    @Email(message = "email is required")
    private String email;

    @Column(name = "phone_no")
    @NotBlank(message = "enter a phone number (should be in 10 digits)")
    //@Pattern(regexp = "^//d{10}$")
    private String phone_no;

    @Column(name = "password")
    @NotBlank(message = "enter a valid password")
    @Size(min = 8, message = "password include at least one number and one special character")
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$", message = "Password must contain at least one number and one special character")
    private String password;

    //@NotBlank(message = "enter a role")

    @ManyToOne(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role Rolebase;

    @Column(name = "status")
    @NotNull(message = "status should not be null")
    private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        String role = "";
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}














/*
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotBlank(message = "Name is mandatory")
    //@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    //@NotBlank(message = "Email is mandatory")
    //@Email(message = "Email should be valid")
    private String email;

    //@NotBlank(message = "Phone number is mandatory")
    //@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone_no;

    //@NotBlank(message = "Password is mandatory")
    //@Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    private String role;
    private String Status;


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
*/