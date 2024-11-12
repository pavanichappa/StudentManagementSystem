package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		studentList = new ArrayList<Student>();

		System.out.println("****************** Student Management System ******************");
		System.out.println("************* Welcome *************");

		Student s1;
		s1 = new Student("Kajal Talreja", 22, "S-1");
		// System.out.println(s1);// override toString method will be called. if we dont
		// have toString method in Student class,
		// it will print address/reference/hashcode of s1.
		s1.printStudentInfo();
		s1.enrollCourses("java");
		s1.enrollCourses("Devops");
		s1.enrollCourses("C#");

		Student s2 = new Student("Uday jadeja", 24, "S-2");
		s2.enrollCourses("Java");

		Student s3 = new Student("Ritu Omkar", 27, "S-3");
		s3.enrollCourses("Devops");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Student result = findStudentById("S-31");
		System.out.println("Result:" + result);

		sortByName();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2)->o1.getName().compareTo(o2.getName());
				
				
				/*new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());//comparision will be done LexographicALLY OR 
			}

		};*/

		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);

	}

	public static Student findStudentById(String studentId) {

		Student result = null;

		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!!"));
		} catch (RuntimeException e) {
			System.out.println("Student with ID:" + studentId + " not found.");
		}
		return result;

	}

}
