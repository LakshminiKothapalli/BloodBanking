package com.cognizant.bloodbankservice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.bloodbankservice.controller.BloodRequestController;
import com.cognizant.bloodbankservice.model.BloodRequest;
import com.cognizant.bloodbankservice.model.User;
import com.cognizant.bloodbankservice.repository.BloodRequestRepository;
import com.cognizant.bloodbankservice.service.BloodRequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder
@AutoConfigureMockMvc
public class BloodBankServiceApplicationTests {

       @Autowired
       BloodRequestService bloodRequestService;

       @Autowired
       BloodRequestRepository bloodRequestRepository;

       @Autowired
       BloodRequestController bloodRequestController;
       @Test
       public void postRequirementTestTrue() {
              List<BloodRequest> bloodRequestList = bloodRequestService.requirements();
              BloodRequest request = new BloodRequest();
              String userName = "user";
              request.setName("user");
              request.setBloodGroup("A+");
              request.setArea("Hyderabad");
              request.setState("Telangana");
              request.setPincode(500032);
              bloodRequestService.postRequirement(request, userName);
              assertEquals(bloodRequestList.isEmpty(), false);

       }

       @Test
       public void postRequirementTestFalse() {
              List<BloodRequest> bloodRequestList = bloodRequestService.requirements();
              BloodRequest request = new BloodRequest();
              String userName = "user";
              request.setName("user");
              request.setBloodGroup("O+");
              request.setArea("Hyderabad");
              request.setState("Telangana");
              request.setPincode(500032);
              bloodRequestService.postRequirement(request, userName);
              assertEquals(bloodRequestList.isEmpty(), true);

       }

       @Test
       public void contextLoads() {
              assertThat(bloodRequestController).isNotNull();
       }

       @Test
       public void bloodAvailabilityTestTrue() {
              List<User> userList = bloodRequestService.bloodAvailability("O+", 600001);
              assertEquals(userList.isEmpty(), false);
       }

       @Test
       public void bloodAvailabilityTestFalse() {
              List<User> userList = bloodRequestService.bloodAvailability("O+", 600001);
              assertEquals(userList.isEmpty(), true);
       }
       @Test
       public void getrequirementsTestTrue() {
              List<BloodRequest> bloodRequestList = bloodRequestRepository.findAll();
              assertEquals(bloodRequestList.isEmpty(), false);
       }

       @Test
       public void getrequirementsTestFalse() {
              List<BloodRequest> bloodRequestList = bloodRequestRepository.findAll();
              assertEquals(bloodRequestList.isEmpty(), true);
       }

     

       @Test
       public void requirementsTestTrue() {
              List<BloodRequest> bloodRequestList = bloodRequestService.requirements();
              assertEquals(bloodRequestList.isEmpty(), false);
       }

       @Test
       public void requirementsTestFalse() {
              List<BloodRequest> bloodRequestList = bloodRequestService.requirements();
              assertEquals(bloodRequestList.isEmpty(), true);
       }

      
}

