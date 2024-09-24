package com.codegnan.university.management;

public class Course {
	private String title;//title of the course.
	//Constructor to intialize the course with title.
	public Course(String title) {
		this.title=title;
	}
	public String getTitle() {
	return title;
}

public String toString(){
	return title;
}
}

