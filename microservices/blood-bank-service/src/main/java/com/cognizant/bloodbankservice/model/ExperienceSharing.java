package com.cognizant.bloodbankservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "experience_sharing")
public class ExperienceSharing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "es_id")
	private Integer id;
	
	@Column(name = "es_hp_name")
	private String hospitalName;
	
	@Column(name = "es_hp_area")
	private String hospitalArea;

	@Column(name = "es_feedback")
	private String feedBack;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="es_us_id_fk")
	private User userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalArea() {
		return hospitalArea;
	}

	public void setHospitalArea(String hospitalArea) {
		this.hospitalArea = hospitalArea;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ExperienceSharing [id=" + id + ", hospitalName=" + hospitalName + ", hospitalArea=" + hospitalArea
				+ ", feedBack=" + feedBack +"]";
	}

	
	
	
	
	
	
	

}
