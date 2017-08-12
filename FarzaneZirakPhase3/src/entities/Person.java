package entities;
import entities.House;
public class Person {
    private String _name;
    private House _house;
    private BloodStatus _bloodStatus;
    private School _school;
    private String _birthday;

    /*constructors*/
    public Person(String name){
        _name = name;
        _house = new House();
        _bloodStatus = BloodStatus.Default;
        _school = new School();
        _birthday = "";
    }
    public Person(){
        this("");
    }
    public Person(String name, House house, BloodStatus val, School school, String birthday){
        _name = name;
        _house = house;
        _bloodStatus = val;
        _school = school;
        _birthday = birthday;
    }
    /*Getters*/
    public String getName(){
        return _name;
    }
    public House getHouse(){
        return _house;
    }
    public BloodStatus getBloodStatus(){
        return _bloodStatus;
    }
    public School getSchool(){
        return _school;
    }
    public String getBirthday(){
        return _birthday;
    }
    /*Setters*/
    public void setName(String name){
        _name = name;
    }
    public void setHouse(House house){
        _house = house;
    }
    public void setBloodStatus(BloodStatus val){
        _bloodStatus = val;
    }
    public void setSchool(School school){
        _school = school;
    }
    public void setBirthday(String birthday){
        _birthday = birthday;
    }
    /*Methods*/
    public String toString(){
        return "Person{\nName: " + _name + "\nHouse: " + _house.getName() + "\nBlood Status: " 
                + _bloodStatus + "\nSchool: " + _school.getName() + "\nBirthday: " + _birthday + "\n}";
    }
    
}
