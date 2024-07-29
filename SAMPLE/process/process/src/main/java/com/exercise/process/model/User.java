package com.exercise.process.model;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;


@Entity

@Table(name = "user_details")
public class User {
    @Id

    private int id;
    private String name;
    private String email;
    private String phone_no;
    private String password;
    private final String role="User";
    private String status="inactive";

    /*public User(String name,String email,String phone_no,String password){
        this.name=name;
        this.email=email;
        this.phone_no=phone_no;
    }*/
/*
    public static void main(String[] args) {
        User u=new User("siva","hsiva7@gmail.com","9344204425");
        System.out.println(u);
    }

    @Override
    public String toString() {
        return "User details is {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }
*/

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
