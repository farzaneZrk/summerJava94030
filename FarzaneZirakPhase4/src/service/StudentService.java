package service;

import entities.House;
import entities.Student;

public class StudentService {
    private Student _student; /* The student the services are performed at */

    public StudentService(Student student){
        _student = student;
    }

    public void setStudent(Student student){
        _student = student;
    }

    public Student getStudent(){
        return _student;
    }

    public void sortToHouse(House house){
        house.addStudent(_student);
    }

}
