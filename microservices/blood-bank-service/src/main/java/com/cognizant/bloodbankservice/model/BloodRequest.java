package com.cognizant.bloodbankservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blood_request")
public class BloodRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "req_id")
	private Integer id;

	@Column(name = "req_bloodgroup")
	private String bloodGroup;
	
	@Column(name = "req_name")
	private String name;
	
	@Column(name = "req_contactnumber")
	private Integer contactNo;
	
	@Column(name="req_state")
	private String state; 
	
	@Column(name="req_area")
	private String area;
	
	@Column(name="req_pincode")
	private Integer pincode;
	

	@ManyToOne
	@JoinColumn(name = "req_us_id_fk")
	private User userId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	



	@Override
	public String toString() {
		return "BloodRequest [id=" + id + ", bloodGroup=" + bloodGroup + ", name=" + name + ", contactNo=" + contactNo
				+ ", state=" + state + ", area=" + area + ", pincode=" + pincode + ", userId=" + userId + "]";
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	
	
	
	
}
