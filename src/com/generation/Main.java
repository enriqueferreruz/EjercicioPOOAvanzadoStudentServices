package com.generation;

import com.generation.exceptions.CourseNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
       
	    studentService.setNewStudent( "1030");
	    studentService.setNewStudent("1040");
       
	    studentService.students.put( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.students.put( "1040", new Student( "Ian", "1040", 28 ) );
        studentService.students.put( "1050", new Student( "Elise", "1050", 26 ) );
        studentService.students.put( "1020", new Student( "Santiago", "1020", 33 ) );

        studentService.showAllCourses();
        try {
			studentService.enrollStudents( "Math","1030" );
		} catch (CourseNotFoundException e) {
			System.out.println("course not found!");
		}
        
        studentService.showEnrolledStudents(null);
    }
    
}
