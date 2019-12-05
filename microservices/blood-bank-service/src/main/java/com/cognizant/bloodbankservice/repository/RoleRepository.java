package com.cognizant.bloodbankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByName(String user);
}
