package com.studentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}
	}

	public void enrollCourses(String course) {
		if(validateCourseName(course)) {
				if (!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student is added to " + course + " successfully!!!");
		} else {
			System.err.println("Student has already enrolled to the course");
		}}
	}

	public void printStudentInfo() {
		System.out.println("********** Student Data **********");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled Courses: " + courses);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// validation method
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age!!.Student age needs to be in between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String stringRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(stringRegex);
		java.util.regex.Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name: Please enter alphabets only");
			return false;
		}
	}

	public boolean validateStudentId(String studentId) {
		String studentIdRegex = "^S-[0-9]+$";// we can replace [0-9] with \\d too
		Pattern idPattern = Pattern.compile(studentIdRegex);
		java.util.regex.Matcher idMatcher = idPattern.matcher(studentId);
		if (idMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid StudentId: Please enter in the correct format like S-123");
			return false;
		}
	}
	
	public boolean validateCourseName(String course) {
		if(course.equalsIgnoreCase("Java")||course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("Devops")) {
			return true;
		}else {
			System.err.println("Invalid Course: Please choose one of the courses from the list:[Java, DSA, Devops]");
			return false;
		}
	}

}
