package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses_28012022")
public class Courses {
	
	@Id
	@GeneratedValue
	@Column(name="course_id")
	private int courseId;
	
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_type")
	private String courseType;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy ="courses")
	private List<Student> students;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
