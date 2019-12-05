package com.cognizant.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE u.username=?1")
	public User findByUsername(String user);

	/*@Query("SELECT u.menuList FROM User u WHERE u.name=?1")
	public Set<MenuItem> getMenuItems(String id);*/

}
