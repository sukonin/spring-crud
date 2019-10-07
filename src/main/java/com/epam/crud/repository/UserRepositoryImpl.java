package com.epam.crud.repository;

import com.epam.crud.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final String INSERT_MESSAGE_SQL = "insert into user (username, password, role) values (:username,:password,:role)";


  public UserRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public User save(User user) {
    KeyHolder holder = new GeneratedKeyHolder();

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("username", user.getUsername())
        .addValue("password", user.getPassword())
        .addValue("role", user.getRole());

    namedParameterJdbcTemplate.update(INSERT_MESSAGE_SQL, parameters, holder);
    user.setId(holder.getKey().longValue());

    return user;
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
