package com.epam.crud.controller;

import com.epam.crud.model.User;
import com.epam.crud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/hello")
  public String welcome() {
    return "welcome";
  }

  @PostMapping("/user/")
  public User createUser(User user) {
    return userService.save(user);
  }
}
