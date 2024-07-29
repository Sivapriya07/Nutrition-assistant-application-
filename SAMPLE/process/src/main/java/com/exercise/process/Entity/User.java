package com.exercise.process.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "userdetail")
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


    @ManyToOne(targetEntity = Role.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

    @Column(name = "status")
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



    public String getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
                ", status='" + status + '\'' +
                '}';
    }

    public User(){

    }

    public User(String name, String email, String phone_no, String password, Role role, String status) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}