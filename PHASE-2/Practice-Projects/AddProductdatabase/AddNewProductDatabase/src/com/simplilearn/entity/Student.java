package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_28012022")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	public List<PhoneNumber> phoneNumbers;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_courses_link_28012022", joinColumns = {
			@JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	public List<Courses> courses;

	@Embedded
	public Address address;

	public String getAddress() {
		StringBuilder sb = new StringBuilder();

		if (address != null) {
			sb.append(this.address.getStreet());
			sb.append(", " + address.getCity());
			sb.append(", " + address.getState());
		}
		return sb.toString();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCourses() {
		StringBuilder sb = new StringBuilder();
		if (courses != null) {
			for (Courses pn : courses) {
				sb.append(pn.getCourseName() + ", ");
			}
		}
		return sb.toString();
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneNumbers() {
		StringBuilder sb = new StringBuilder();
		if (phoneNumbers != null) {
			for (PhoneNumber pn : phoneNumbers) {
				sb.append(pn.getPhoneNumber() + ", ");
			}
		}
		return sb.toString();
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
