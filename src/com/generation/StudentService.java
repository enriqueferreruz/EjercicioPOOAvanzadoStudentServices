package com.generation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.generation.exceptions.CourseNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException
    {
        Course course = courseList.get( courseName );
        if (course == null) {
            throw new CourseNotFoundException();
        }
        
        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }

    public void unEnrollStudents( String courseName, String studentID )
    {
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }
    }
    public void setNewStudent (String studentID) {
        students.put(studentID, new Student ("name", "id", 0));

    }
    public void showEnrolledStudents(String courseId){
        //implement using collections loops
    	  for (String studentID : coursesEnrolledByStudents.keySet()) {
    	        List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentID);
    	        //mejor un if(enrolledCourses.contains(course))
    	        //Student student= students.get(studentID);
    	        //syso(student)
    	        for (Course course : enrolledCourses) {
    	            if (course.getName().equals(courseId)) {
    	                System.out.println("Student ID: " + studentID + ", " + students.get(studentID).toString());
    	            }
    	        }
    	        

    	    }//for
    }//metodoshowEnrolledStudents

    public void showAllCourses(){
        //implement using collections loops
    	 for (Course course : courseList.values()) {
    	        System.out.println(course);
    	    }//for con .values
    	
    }//metShowAll
}