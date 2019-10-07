package com.epam.crud.model;

import java.io.Serializable;

public class User implements Serializable {

  private Long id;
  private String username;
  private String password;
  private String role;

  public void setRole(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
