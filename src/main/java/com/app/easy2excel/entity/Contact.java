package com.app.easy2excel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="contact")
@Getter
@Setter
@ToString
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Email
	@NotEmpty(message = "email id is required")
	@Column(name="email")
	private String email;

	@Size(min=10,max=10,message = "phone no must be ten character")
	@Pattern(regexp = "[0-9]+",message = "phone no must be numeric value")
	@Column(name="phone_no")
	private String phoneNo;
	
}
