package com.codegnan.university.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//manages the university's students,professor,courses.
public class UniversityManagement {
	private List<Student> students;//list to hold Students
	private List<Professor> professors;//list to hold professors
	private List<Course> courses;//list to hold  courses.
	//construcor to intilialize empty list for students,Professors,Courses.
	public UniversityManagement() {
		students=new ArrayList<>();
		professors= new ArrayList<>();
		courses=new ArrayList<>();
		
		
	}
	//method to add  a student
	public void addStudent(String name) {
		students.add(new Student(name));
	}
	public void addProfessor(String name) {
		professors.add(new Professor(name));
	}
	public void addCourse(String title) {
		courses.add(new Course(title));
	}
	//method to enroll a student in course
	public void enrollStudentInCourse(String studentName,String courseTitle) {
		Student student=findStudentByName(studentName);//find the Student by name;
		Course course=findCourseByTitle(courseTitle);//find the course by title
		 
		if(student!=null&&course!=null) {
			student.enrollInCourse(course);//enroll the student in course
		}else {
			System.out.println("Student or Course Not FOUND");//error message is not found.
		}
	}
//method to assign course in the professor.
	public void assignCourseToProfessor(String professorName,String courseTitle) {
		
		Professor professor=findProfessorByName(professorName);//find the professor by name.
		Course course=findCourseByTitle(courseTitle);
		if(professor!=null && course!=null) {
			professor.assignCourse(course);//assign the courses to the professor
		}else {
			System.out.println("Professor or Course NOT found");//Error message if not found
		}
		
	}
	
	//method list of all students 
	public void listStudents() {
		System.out.println("List of Students in university : ");
		for(Student student:students) {
			System.out.println(student);//print each students name.
		}
	}
	//method to add professors
	public void listProfessors() {
		System.out.println("list of Professors in university : ");
		for(Professor professor:professors) {
			System.out.println(professor);//print each professor's name
		}
	}
	//method to list all courses
	public void listCourses() {
		System.out.println("Courses : ");
		for(Course course:courses) {
			System.out.println(course);//print each course name
		}
	}
	//method to display the courses a student enrolled in.
	public void displayStudentCourses(String studentname) {
		Student student=findStudentByName(studentname);//find student by name
		if(student!=null) {
			System.out.println("Course for student" +studentname +" : ");
			for(Course course:student.getEnrolledCourses()) {
				System.out.println(course);//print each enrolled course
			}
		}else {
			System.out.println("Student not found");//error message  if student is not found
		}
		
	}
	//method to display course assigned to professor.
	public void displayProfessorCourses(String professorName) {
		Professor professor=findProfessorByName(professorName);
		if(professor!=null) {
			System.out.println("Course assigned to a professor : "+professorName + " : ");
			for(Course course:professor.getAssignedCourses()) {
				System.out.println(course);//print each Assigned course
			}
		}else {
			System.out.println("professor not Found : ");//errror message if professor not found
		}
	}
	//helper method to find a student by name.
	private Student findStudentByName(String name) {
		for(Student student:students) {
			if(student.getName().equals(name)) {
				return student;//return student if found.
			}
		}
		return null;//return null ifv student not found
	}
	//helper method to find a professor name.
		private Professor findProfessorByName(String name) {
			for(Professor professor:professors) {
				if(professor.getName().equals(name)) {
					return professor;//return professor if found.
				}
			}
			return null;
		}
		//helper method to find a course by title.
				private Course findCourseByTitle(String title) {
					for(Course course:courses) {
						if(course.getTitle().equals(title)) {
							return course;//return professor if found.
						}
					}
					return null;
				}
				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniversityManagement management=new UniversityManagement();
		Scanner scanner=new Scanner(System.in);
		boolean running=true;
		while(running) {
			System.out.println("\nUniversityManagement");
			System.out.println("1.Add Students");
			System.out.println("2.Add professor");
			System.out.println("3.Add course");
			System.out.println("4.Enroll Student in course");
			System.out.println("5.Assign Course to professor");
			System.out.println("6.List of Students");
			System.out.println("7.List of professor");
			System.out.println("8.list of courses.");
			System.out.println("9.Display Student courses");
			System.out.println("10.Display professor courses");
			System.out.println("11.Exit");
			int option=scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
			case 1:
				System.out.println("enter student name");
				String studentName=scanner.nextLine();
				management.addStudent(studentName);
				break;
				
			case 2:
				System.out.println("Enter Professor Name:");
				String professorName=scanner.nextLine();
				management.addProfessor(professorName);
				break;
				
			case 3:
				System.out.println("Enter course Title");
				String courseTitle=scanner.nextLine();
				management.addCourse(courseTitle);
				break;
				
			case 4:

				System.out.println("Enter student name:");
				String enrollStudent=scanner.nextLine();
				System.out.println("Enter course name:");
				String enrollCourse=scanner.nextLine();
				management.enrollStudentInCourse(enrollStudent,enrollCourse);
				break;
				
			case 5:
				System.out.println("Enter professor name:");
				String assignProfessor=scanner.nextLine();
				System.out.println("Enter Course title:");
				String assignCourse=scanner.nextLine();
				management.assignCourseToProfessor(assignProfessor, assignCourse);
				break;
			
			case 6:
				management.listStudents();
				break;
				
			case 7:
				management.listProfessors();
				break;
			case 8:
				management.listCourses();
				break;
			case 9:
				System.out.println("Enter student name:");
				String displayStudent=scanner.nextLine();
				management.displayStudentCourses(displayStudent);
				break;
			case 10:
				System.out.println("Enter professor name:");
				String displayProfessor=scanner.nextLine();
				management.displayProfessorCourses(displayProfessor);
				break;
			case 11:
				running=false;//exit the loop.
				System.out.println(" Exiting...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 11."); // Handle invalid input
                break;
        }
    }

    scanner.close(); // Close the scanner
}

				
				

			}
		
