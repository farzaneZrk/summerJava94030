package service;

import entities.House;
import entities.School;
import entities.Student;

public class SchoolService {
    private School _school; /* The school the services are performed on/at */

    public SchoolService(School school){
        _school = school;
    }
    public SchoolService(){
        this(null);
    }

    public void setSchool(School school){
        _school = school;
    }

    public School getSchool(){
        return _school;
    }
    
    public House sortingHat(Student student){

    }

}
