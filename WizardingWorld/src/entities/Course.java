package entities;

import java.util.Vector;
public class Course {
    /*Variables*/
    private String _name;
    private char _minGrade;
    private String _professorName;
    private int _year;
    private Vector<String> _studentNames;
    /*Constructors*/
    public Course (String name){
        _name = name;
        _professorName = "";
        _minGrade = '\0';
        _year = 0;
        _studentNames = new Vector<String>();
    }
    public Course(){
        this ("");
    }
    public Course(String name, String professorName, char minGrade, int year){
        _name = name;
        _professorName = professorName;
        _minGrade = minGrade;
        _year = year;
    }
    public Course(String name, String professorName, char minGrade, int year, Vector<String> studentNames){
        this(name, professorName, minGrade, year);
        this.setStudentNames(studentNames);
    }
    /*Getters*/
    public String getName(){
        return _name;
    }
    public String getProfessorName(){
        return _professorName;
    }
    public char getMinGrade(){
        return _minGrade;
    }
    public int getYear(){
        return _year;
    }
    public Vector<String> getStudentNames(){
        return _studentNames;
    }
    /*Setters*/
    public void setName(String name){
        _name = name;
    }
    public void setProfessorName(String professorName){
        _professorName = professorName;
    }
    public void setMinGrade(char minGrade){
        _minGrade = minGrade;
    }
    public void setYear(int year){
        _year = year;
    }
    public void setStudentNames(Vector<String> studentNames){
        _studentNames = studentNames;
    }
}
