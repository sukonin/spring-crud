package com.epam.crud.repository;

import com.epam.crud.model.User;

public interface UserRepository {

  int save(User user);

  User findById(Long id);

  User update(Long id, User user);

  void deleteById(Long id);
}
