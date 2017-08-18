package entities;

import entities.Student;


import java.util.Vector;
public class Course {
    /*      Variables      */
    protected String _name;                   /* The name of course */
    protected Grades _minGrade;               /* Min grade required in the OWLs to continue the course */
    protected Professor _professor;           /* Professor teaching the course at the school the course is */
    protected int _year;                      /* The year this course is offered */
    private Vector<Student> _students;      /* List of the students in the course at the given year */
    
    /*      Constructors    */

    public Course(String name, Professor professor, Grades minGrade, int year, Vector<Student> students){
        _name = name;
        _professor = professor;
        _minGrade = minGrade;
        _year = year;
        _students = students;
    }
    public Course (String name){
        this(name, null, Grades.Default, 0, new Vector<Student>());
    }
    public Course(){
        this ("");
    }
    public Course(String name, Professor professor, Grades minGrade){
        this(name, professor, minGrade, 0, new Vector<Student>());
    }
    public Course(String name, Professor professor, Grades minGrade, int year){
        this(name, professor, minGrade, year, new Vector<Student>());
    }
    /*      Getters     */

    public String getName(){
        return _name;
    }
    public Professor getProfessor(){
        return _professor;
    }
    public Grades getMinGrade(){
        return _minGrade;
    }
    public int getYear(){
        return _year;
    }
    public Vector<Student> getStudents(){
        return _students;
    }
    /*      Setters     */

    public void setName(String name){
        _name = name;
    }
    public void setProfessor(Professor professor){
        _professor = professor;
    }
    public void setMinGrade(Grades minGrade){
        _minGrade = minGrade;
    }
    public void setYear(int year){
        _year = year;
    }
    public void setStudents(Vector<Student> students){
        _students = students;
    }
    /*      Helper Methods      */

    public void addStudent(Student student){
        if(_students == null)
            _students = new Vector<Student>();
        _students.add(student);
    }

    public String toString(){
        return "Course{\nName: " + _name + "\nMinGrade: "
        + _minGrade + "\nProfessor: " + _professor.getName()
        +"\nYear: " + _year +"\n}";
    }

    public String allToString(){
        String returnString = this.toString().substring(0, this.toString().length()-1) + "\t";
        if(!(_students.isEmpty())) {
            returnString =  returnString.substring(0, returnString.length()-1) + "Students:\n\t";
            for(int i=0; i<_students.size(); i++)
                returnString += _students.elementAt(i).getName() + "\n\t";
        }
        return returnString.substring(0, returnString.length()-1) + "}";
    }
}
