package entities;
import entities.House;
public class Person {
    protected String _name;                       /* Person's name */
    protected House _house;                       /* If a person does not belong in a house, the value is "N/A*/
    protected BloodStatus _bloodStatus;           /* Blood status of the person */
    protected School _school;                     /* The school this person id/did attend or teach */
    protected String _birthday;                   /* A string that is to be checked that represents a date */

    /*      constructors       */

    public Person(String name, House house, BloodStatus val, School school, String birthday){
        _name = name;
        _house = house;
        _bloodStatus = val;
        _school = school;
        _birthday = birthday;
    }
    public Person(String name){
        this(name, null, BloodStatus.Default, null, "00.00.0000");
    }
    public Person(){
        this("");
    }
    /*      Getters     */

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
    /*      Setters     */

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
    /*      Helper Methods      */
    
    public String toString(){
        return "Person{\nName: " + _name + "\nHouse: " + _house.getName() + "\nBlood Status: " 
                + _bloodStatus + "\nSchool: " + _school.getName() + "\nBirthday: " + _birthday + "\n}";
    }
    
}
