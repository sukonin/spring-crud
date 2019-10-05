package com.epam.crud.service;

import com.epam.crud.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public User save(User user) {
    System.out.println(user);
    return null;
  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public User update(Long id, User user) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }
}
