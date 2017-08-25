package service;

import java.io.*;
import java.util.Vector;

import entities.*;


public class CourseService {
    public Course _course;                  /* The course the services are performed on/at*/
    public Vector<Course> _allCourses;      /* All the courses in the system */
/*      Constructors        */

    public CourseService(Course course, Vector<Course> allCourses){
        _course = course;
        _allCourses = allCourses;
    }
    public CourseService(Course course){
        this(course, null);
    }
    public CourseService(){
        this(null, null);
    }
/*      Setters        */

    public void setCourse(Course course){
        _course = course;
    }
    public void setAllCourses(Vector<Course> allCourses){
        _allCourses = allCourses;
    }
/*      Getters        */

    public Course getCourse(){
        return _course;
    }
    public Vector<Course> getAllCourses(){
        return _allCourses;
    }
/*      Helper Methods        */

public void getData(String fileName){
    _allCourses = new Vector<Course>();
    try {
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String line;

        while (!(line = file.readLine()).equals("$")) {
            Course course = new Course(line);
            while(!(line = file.readLine()).equals("*")){
                course.setMinGrade(Grades.valueOf(line));
                course.setProfessor(new Professor(file.readLine()));
                int year = Integer.parseInt(file.readLine());
                course.setYear(year);
                int numOfStudents = Integer.parseInt(file.readLine());
                for(int i=0; i<numOfStudents; i++)
                    course.addStudent(new Student(file.readLine()));
            }
            _allCourses.add(course);
        }
        file.close();
    } catch (IOException e) {}

}

public void setData(){
    try{
        BufferedWriter file = new BufferedWriter(new FileWriter("myCourseDB.txt"));         // I give a different name to this file to test it 
        for (Course course : _allCourses){
            file.write(course.getName() + "\n");
            file.write(course.getMinGrade() + "\n");
            file.write(course.getProfessor().getName() + "\n");
            file.write(course.getYear() + "\n");
            file.write(course.getStudents().size() + "\n");
            for(Student student : course.getStudents())
                file.write(student.getName() + "\n");
            file.write( "*\n");
        }
        file.write( "$\n");
        file.close();

    }catch (IOException exception){}

}

}
