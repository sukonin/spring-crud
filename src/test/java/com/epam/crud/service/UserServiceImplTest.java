package com.epam.crud.service;

import com.epam.crud.model.User;
import com.epam.crud.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

  @Mock
  private UserRepository userMockRepo;

  private UserService userService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl(userMockRepo);
  }

  @Test
  public void save() {
    User user = new User();
    user.setId(1L);
    user.setUsername("username");
    user.setPassword("password");

    Mockito.when(userMockRepo.save(user)).thenReturn(1);

    int savedId = userService.save(user);

    Assert.assertEquals(1L, savedId);
  }
}
