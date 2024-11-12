package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		studentList = new ArrayList<Student>();

		System.out.println("****************** Student Management System ******************");

		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("************* Welcome *************");
			System.out.println("1.Register a student  ");
			System.out.println("2. Find student with student ID ");
			System.out.println("3.List all student information ");
			System.out.println("4. List student information in sorted order ");
			System.out.println("5.Exit ");

			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option. Please enter a number between 1 and 5");
			}
		}

	}

	private static void exit() {
		System.out.println("Good Bye!!!");
		System.exit(0);
		
	}

	private static void printAllStudentData() {
		if (studentList.size() > 0) {
			System.out.println("************* Print all student data *************");
			for (Student student : studentList) {
				student.printStudentInfo();

			}
			System.out.println("**************************");
		} else {
			System.err.println("Student List is empty");
		}
	}

	private static void findStudentById(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Enter student ID : ");
		String studentId = scanner2.next();
		try {
			studentFound = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!!"));
		} catch (RuntimeException e) {
			System.out.println("Student with ID:" + studentId + " not found.");
		}
		studentFound.printStudentInfo();
		;

	}

	private static void enrollStudent(Scanner scanner2) {
		scanner = new Scanner(System.in);

		System.out.println("Enter Student Name...");
		String studentName = scanner.next();

		System.out.println("Enter Student Age...");
		int studentAge = scanner.nextInt();

		System.out.println("Enter Student Id...");
		String studentId = scanner.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Please enroll to a course...Type done if you want to exit");
			String course = scanner.next();
			if (course.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourses(course);
		}
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName());//comparision will be done
		 * LexographicALLY OR }
		 * 
		 * };
		 */

		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();

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
