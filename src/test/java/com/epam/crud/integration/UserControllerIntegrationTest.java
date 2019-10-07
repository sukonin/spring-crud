package com.epam.crud.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.epam.crud.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerIntegrationTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders
        .webAppContextSetup(this.webApplicationContext)
        .build();
  }

  @Test
  public void welcomeTest() throws Exception {
    String body = mockMvc.perform(get("/hello")).andReturn().getResponse()
        .getContentAsString();

    Assert.assertEquals("welcome", body);
  }

  @Test
  public void findUserByIdTest() throws Exception {
    String body = mockMvc.perform(get("/user/1")).andReturn().getResponse()
        .getContentAsString();
    System.out.println(body);
  }
}
