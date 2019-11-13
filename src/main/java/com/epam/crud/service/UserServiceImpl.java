package com.epam.crud.service;

import com.epam.crud.model.User;
import com.epam.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User user) {
    user.setRole("USER");
    return userRepository.save(user);
  }

  @Override
  public User findById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User update(Long id, User user) {
    user.setId(id);
    return userRepository.update(user);
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
