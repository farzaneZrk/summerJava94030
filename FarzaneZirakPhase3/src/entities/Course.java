package entities;
import entities.Student;
import entities.Grades;
import java.util.Vector;
public class Course {
    /*Variables*/
    private String _name;
    private Grades _minGrade;
    private Professor _professor;
    private int _year;
    private Vector<Student> _students;
    
    /*Constructors*/
    public Course (String name){
        _name = name;
        _professor = new Professor();
        _minGrade = Grades.Default;
        _year = 0;
        _students = new Vector<Student>();
    }
    public Course(){
        this ("");
    }
    public Course(String name, Professor professor, Grades minGrade){
        _name = name;
        _professor = professor;
        _minGrade = minGrade;
        _year = 0;
        _students = new Vector<Student>();
    }
    public Course(String name, Professor professor, Grades minGrade, int year){
        this(name, professor, minGrade);
        _year = year;
        _students = new Vector<Student>();
    }
    public Course(String name, Professor professor, Grades minGrade, int year, Vector<Student> students){
        this(name, professor, minGrade, year);
        _students = students;
    }
    /*Getters*/
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
    /*Setters*/
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
    /*Methods*/
    public void addStudent(Student student){
        _students.add(student);
    }
    public String halfToString(){
        return "Course{\nName: " + _name + "\nMinGrade: "
        + _minGrade + "\nProfessor: " + _professor.getName()
        +"\nYear: " + _year +"\n";
    }
    public String toString(){
        String returnString = this.halfToString() + "\t";
        if(!(_students.isEmpty())) {
            returnString =  returnString.substring(0, returnString.length()-1) + "Students:\n\t";
            for(int i=0; i<_students.size(); i++)
                returnString += _students.elementAt(i).getName() + "\n\t";
        }
        return returnString.substring(0, returnString.length()-1) + "}";
    }
}
