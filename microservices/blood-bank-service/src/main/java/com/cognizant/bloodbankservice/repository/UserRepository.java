package com.cognizant.bloodbankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE u.username=?1")
	public User findByUsername(String user);


	
	@Query(value="select * from user u where us_bloodgroup=:bloodgroup and us_pincode=:pincode",nativeQuery=true)
	
	public List<User> bloodAvailability(@Param(value = "bloodgroup") String bloodgroup,@Param(value = "pincode")int pincode);

}
