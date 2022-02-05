package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone_28012022")
public class PhoneNumber {

	@Id
	@GeneratedValue
	@Column(name="phone_id")
	private int phoneId;
	
	@Column(name="phone_type")
	private String phoneType;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
