package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Address;
import com.simplilearn.entity.Courses;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentSrevlet
 */
@WebServlet("/add-student")
public class AddStudentSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = populateStudent(request);
		SessionFactory sf =HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx =session.beginTransaction();
		session.save(student);
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.println("Student saved successfully!");
	}

	private Student populateStudent(HttpServletRequest request) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String phone1 = request.getParameter("phone_1");
		String phoneType1 = request.getParameter("types1");
		
		String phone2 = request.getParameter("phone_2");
		String phoneType2 = request.getParameter("types2");
		
		
		String phone3 = request.getParameter("phone_3");
		String phoneType3 = request.getParameter("types3");
		
		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
		
		PhoneNumber p1 = new PhoneNumber();
		p1.setPhoneNumber(phone1);
		p1.setPhoneType(phoneType1);
		p1.setStudent(student);
		
		PhoneNumber p2 = new PhoneNumber();
		p2.setPhoneNumber(phone2);
		p2.setPhoneType(phoneType2);
		p2.setStudent(student);
		
		PhoneNumber p3 = new PhoneNumber();
		p3.setPhoneNumber(phone3);
		p3.setPhoneType(phoneType3);
		p3.setStudent(student);
		
		List<PhoneNumber> phones  = new ArrayList<>();
		phones.add(p1);
		phones.add(p2);
		phones.add(p3);
		
		student.setPhoneNumbers(phones);
		
		
		// ------------------ Populate Courses
		List<Student> students = new ArrayList<>();
		students.add(student);
		
		String courseName1 = request.getParameter("courses_1");
		String courseType1 = request.getParameter("courseType_1");
		
		String courseName2 = request.getParameter("courses_2");
		String courseType2 = request.getParameter("courseType_2");
		
		String courseName3 = request.getParameter("courses_3");
		String courseType3 = request.getParameter("courseType_3");
		
		Courses course1 = new Courses();
		course1.setCourseName(courseName1);
		course1.setCourseType(courseType1);
		course1.setStudents(students);
		
		Courses course2 = new Courses();
		course2.setCourseName(courseName2);
		course2.setCourseType(courseType2);
		course2.setStudents(students);
		
		Courses course3 = new Courses();
		course3.setCourseName(courseName3);
		course3.setCourseType(courseType3);
		course3.setStudents(students);
		
		List<Courses> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		student.setCourses(courses);
		
		//============== Populate Address details
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		student.setAddress(addr);
		
		
		
		return student;
	}

}
