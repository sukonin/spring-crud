package com.epam.crud.repository;

import com.epam.crud.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int save(User user) {
    return jdbcTemplate.update("insert into user (id, username, password) values (?,?,?)",
        user.getId(), user.getUsername(), user.getPassword());
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
