package com.cognizant.bloodbankservice.repository;


import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbankservice.model.SlotBooking;

@Repository
public interface DonorSlotRepository extends JpaRepository<SlotBooking, Integer>{

	@Query(value="select count(*) as no_of_patients from hospital h join slot_booking s on h.hp_id = s.sl_hp_id_fk=:hospitalId where s.sl_time=:date ",nativeQuery=true)
	public int getNoOfDonors(@Param(value = "hospitalId")int hospitalId,@Param(value = "date")Time date);
	

}
