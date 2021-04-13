package com.jwtdemo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @Column(length=50)
    private String username;
    @NotEmpty
    @NotNull
    @Column(length=150)
    private String password;
    @NotEmpty
    @NotNull
    @Column(length=30)
    private String role_id;
    private int active;
    
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public List<String> getRoleList(){
        if(this.role_id.length() > 0){
            return Arrays.asList(this.role_id.split(","));
        }
        return new ArrayList<>();
    }

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public UserDao(String username, String password, String roles){
        this.username = username;
        this.password = password;
        this.role_id = roles;
        this.active = 1;
    }

    public UserDao(){}

}

