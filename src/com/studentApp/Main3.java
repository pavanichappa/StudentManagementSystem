package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		studentList = new ArrayList<Student>();

		System.out.println("****************** Student Management System ******************");
		System.out.println("************* Welcome *************");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student name:");
		String name = scanner.next();//to read string value
		System.out.println("You have entered the Student name is " +name);
		
		System.out.println("Enter Student Age:");
		int age = scanner.nextInt();//to read integer
		System.out.println("The student age is " +age);
		
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
