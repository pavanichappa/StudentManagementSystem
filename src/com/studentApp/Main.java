package com.studentApp;

public class Main {

	public static void main(String[] args) {
		System.out.println("****************** Student Management System ******************");
		System.out.println("************* Welcome *************");
		Student s1;
		s1 = new Student("Kajal Talreja", 22, "S-1");
		//System.out.println(s1);// override toString method will be called. if we dont have toString method in Student class,
		                       // it will print address/reference/hashcode of s1.
		s1.printStudentInfo();
		s1.enrollCourses("java");
		s1.enrollCourses("Devops");
		s1.enrollCourses("C#");
		s1.printStudentInfo();
		System.out.println(s1);
		
		Student s2 = new Student("Uday jadeja", 24, "S-2");
				System.out.println(s2);	
		s2.enrollCourses("Java");
		s2.printStudentInfo();
		
		Student s3 = new Student("Ritu Omkar", 27, "S-3");
		System.out.println(s3);
		s3.enrollCourses("Devops");
		s3.printStudentInfo();
	}

}
