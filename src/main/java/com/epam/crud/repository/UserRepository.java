package com.epam.crud.repository;

import com.epam.crud.model.User;

public interface UserRepository {

  User save(User user);

  User findById(Long id);

  User update(User user);

  void deleteById(Long id);
}
