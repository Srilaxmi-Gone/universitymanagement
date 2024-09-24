package com.codegnan.university.management;

import java.util.ArrayList;
import java.util.List;

public class Professor {
private String name;//name of the professor.
private List<Course> assignedCourses;//list to hold courses assigned to the professor.
//constructor to intialize the professor with name and empty list of assigned
//courses.
public Professor(String name) {
	this.name=name;
	this.assignedCourses=new ArrayList<>();
}
//Getter method to retrieve the professor name
public String getName() {
	return name;
}
//method to assign a course to professor.
public void assignCourse(Course course) {
	//check if the courrse is noy already in the list of assigned courses.
	if(!assignedCourses.contains(course)) {
		assignedCourses.add(course);//add course to list of not already present.
	}
}
//Getter method to retrieve the list of courses assigned to the professor.
public List<Course>getAssignedCourses(){
	return assignedCourses;//return the list of assigned courses.
}
//override to String method to provide a String representation of the professor
public String toString() {
	return name;//return the professor name as the String representation.
}
}
