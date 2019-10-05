package com.epam.crud.mapper;

import com.epam.crud.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet resultSet, int i) throws SQLException {
    User user = new User();
    user.setId(resultSet.getLong("ID"));
    user.setUsername(resultSet.getString("USERNAME"));
    user.setPassword(resultSet.getString("PASSWORD"));
    return user;
  }
}
