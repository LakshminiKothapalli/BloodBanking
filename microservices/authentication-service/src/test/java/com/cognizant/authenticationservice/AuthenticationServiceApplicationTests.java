package com.cognizant.authenticationservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authenticationservice.controller.UserController;
import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder
@AutoConfigureMockMvc
public class AuthenticationServiceApplicationTests {

       private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplicationTests.class);

       @Autowired
       UserRepository userRepository;

       @Autowired
       UserController userController;

       @Test
       public void contextLoads() {
       }

       @Test
       public void findByUsernameTestTrue() {
              LOGGER.info("Start");
              User user = userRepository.findByUsername("user");
              String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
              assertEquals(expected, user.getPassword());
              LOGGER.info("End");

       }

       @Test
       public void findByUsernameTestFalse() {
              LOGGER.info("Start");
              User user = userRepository.findByUsername("user");
              String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
              assertNotEquals(expected, user.getPassword());
              LOGGER.info("End");

       }

       @Test
       public void signupTestTrue() throws UserAlreadyExistsException {

    	   User user = new User();
           user.setUsername("mini");
           user.setFirstname("Lakshmini");
           user.setLastname("Kothapalli");
           user.setPassword("123");
           user.setGender("Female");
           user.setContactNo("8639188817");
           user.setBloodgroup("O+");
           user.setEmail("mini@gmail.com");
           user.setAge(21);
           user.setArea("Hyderabad");
           user.setState("Telangana");
           user.setPincode(500032);
           user.setWeight(54);
           userController.signup(user);
           User userDetails = userRepository.findByUsername("mini");
           assertNotNull(userDetails);

       }

       @Test
       public void signupTestFalse() throws UserAlreadyExistsException {

              User user = new User();
              user.setUsername("mini");
              user.setFirstname("Lakshmini");
              user.setLastname("Kothapalli");
              user.setPassword("123");
              user.setGender("Female");
              user.setContactNo("8639188817");
              user.setBloodgroup("O+");
              user.setEmail("mini@gmail.com");
              user.setAge(21);
              user.setArea("Hyderabad");
              user.setState("Telangana");
              user.setPincode(500032);
              user.setWeight(54);
              userController.signup(user);
              User userDetails = userRepository.findByUsername("mini");
              assertNull(userDetails);

       }

}

