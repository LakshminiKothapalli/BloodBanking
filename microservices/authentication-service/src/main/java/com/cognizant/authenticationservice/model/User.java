package com.cognizant.authenticationservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "us_id")
	private Integer id;

	@Column(name = "us_username")
	private String username;
	
	@Column(name = "us_firstname")
	private String firstname;
	
	@Column(name = "us_lastname")
	private String lastname;
	
	@Column(name = "us_age")
	private Integer age;
	
	@Column(name = "us_gender")
	private String gender;
	
	@Column(name = "us_contactnumber")
	private String contactNo;
	
	@Column(name = "us_email")
	private String email;
	
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_weight")
	private Integer weight;
	
	@Column(name = "us_bloodgroup")
	private String bloodgroup;
	
	@Column(name="us_state")
	private String state; 
	
	@Column(name="us_area")
	private String area;
	
	@Column(name="us_pincode")
	private Integer pincode;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id_fk"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id_fk"))
	private Set<Role> roleList;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
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
	
	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", gender=" + gender + ", contactNo=" + contactNo + ", email=" + email
				+ ", password=" + password + ", weight=" + weight + ", bloodgroup=" + bloodgroup + ", state=" + state
				+ ", area=" + area + ", pincode=" + pincode + "]";
	}
	


}
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "us_id")
	private long id;

	@Column(name = "us_name")
	private String username;
	
	@Column(name = "us_firstname")
	private String firstname;
	
	@Column(name = "us_lastname")
	private String lastname;
	
	@Column(name = "us_password")
	private String password;
	@Column(name = "us_age")
	private int age;
	
	@Column(name = "us_gender")
	private String gender;
	
	@Column(name = "us_contactnumber")
	private long contactNo;
	
	@Column(name = "us_email")
	private String email;

	@Column(name = "us_weight")
	private int weight;
	
	@Column(name = "us_addr_id_fk")
	private String address;
	
	@Column(name = "us_bloodgroup")
	private String bloodgroup;

	@Column(name = "us_req_id_fk")
	private int request;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"), inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<MenuItem> menuList;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}*/

	
	

