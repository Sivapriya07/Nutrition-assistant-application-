package com.exercise.process.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "RoleTable")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "rolename")
    private String rolename;
    public Role(){

    }

    public Role(Integer id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename){
        this.rolename=rolename;
    }


}
