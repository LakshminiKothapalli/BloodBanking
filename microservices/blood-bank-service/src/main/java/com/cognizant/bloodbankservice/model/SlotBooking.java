package com.cognizant.bloodbankservice.model;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "slot_booking")
public class SlotBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_id")
	private Integer id;

	@Column(name = "sl_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "sl_time")
	private Time time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sl_hp_id_fk")
	private Hospital hospital;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "SlotBooking [id=" + id + ", date=" + date + ", time=" + time + ", hospital=" + hospital + "]";
	} 
	
	
	
}
