package com.epam.crud.service;

import com.epam.crud.model.User;

public interface UserService {

  User save(User user);

  User findById(Long id);

  User update(Long id, User user);

  void deleteById(Long id);
}
