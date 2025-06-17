package com.ilan.sqlQueryDsl;

import lombok.Builder;

import javax.annotation.processing.Generated;

/**
 * BUsers is a Querydsl bean type
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.BeanSerializer")
@Builder
public class BUsers {

    public BUsers() {
    }

    public BUsers(Boolean active, String email, String fullName, Long id, String password, java.sql.Timestamp registeredAt, String username) {
        this.active = active;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
        this.password = password;
        this.registeredAt = registeredAt;
        this.username = username;
    }

    private Boolean active;

    private String email;

    private String fullName;

    private Long id;

    private String password;

    private java.sql.Timestamp registeredAt;

    private String username;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(java.sql.Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
         return "active = " + active + ", email = " + email + ", fullName = " + fullName + ", id = " + id + ", password = " + password + ", registeredAt = " + registeredAt + ", username = " + username;
    }

}

