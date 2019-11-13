package com.epam.crud.repository;

import com.epam.crud.mapper.UserRowMapper;
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

  private final String INSERT_USER_STATEMENT = "insert into user (username, password, role) values (:username,:password,:role)";
  private final String SELECT_USER_BY_ID = "select * from user where id = :id";
  private final String UPDATE_USER_STATEMENT = "update user set username=:username, password=:password, role=:role where id = :id";
  private final String DELETE_USER_STATEMENT = "delete from user where id = :id";

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

    namedParameterJdbcTemplate.update(INSERT_USER_STATEMENT, parameters, holder);
    user.setId(holder.getKey().longValue());

    return user;
  }

  @Override
  public User findById(Long id) {
    SqlParameterSource parameter = new MapSqlParameterSource()
        .addValue("id", id);

    return namedParameterJdbcTemplate
        .queryForObject(SELECT_USER_BY_ID, parameter, new UserRowMapper());
  }

  @Override
  public User update(User user) {
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", user.getId())
        .addValue("username", user.getUsername())
        .addValue("password", user.getPassword())
        .addValue("role", user.getRole());

    namedParameterJdbcTemplate.update(UPDATE_USER_STATEMENT, parameters);
    return user;
  }

  @Override
  public void deleteById(Long id) {
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", id);

    namedParameterJdbcTemplate.update(DELETE_USER_STATEMENT, parameters);
  }


}
