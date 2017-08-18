package service;

import entities.Course;

public class CourseService {
    public Course _course;                  /* The course the services are performed on/at*/

    public CourseService(Course course){
        _course = course;
    }
    public CourseService(){
        this(null);
    }

    public void setCourse(Course course){
        _course = course;
    }

    public Course getCourse(){
        return _course;
    }
}
