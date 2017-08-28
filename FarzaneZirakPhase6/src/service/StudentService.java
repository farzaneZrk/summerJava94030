package service;

import java.io.*;
import java.util.Vector;

import entities.*;

public class StudentService {
    private Student _student;                           /* The student the services are performed at */
    private Vector<Student> _allStudents;               /* All the students in the system */

/*      Constructors        */

    public StudentService(Student student, Vector<Student> allStudents){
        _student = student;
        _allStudents = allStudents;
    }
    public StudentService(Student student){
        this(student, null);
    }
    public StudentService(){
        this(null, null);
    }
/*      Setters        */

    public void setStudent(Student student){
        _student = student;
    }
    public void setAllStudents(Vector<Student> allStudents){
        _allStudents = allStudents;
    }
/*      Getters        */    

    public Student getStudent(){
        return _student;
    }
    public Vector<Student> getAllStudents(){
        return _allStudents;
    }
/*      Helper Methods        */

    public void sortToHouse(House house){
        house.addStudent(_student);
        _student.setHouse(house);
    }

    public void getData(String fileName){
        _allStudents = new Vector<Student>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;

            while (!(line = file.readLine()).equals("$")) {
                Student student = new Student(line);
                while(!(line = file.readLine()).equals("*")){
                    student.setSchool(new School(line));
                    student.setBloodStatus(BloodStatus.valueOf(file.readLine()));
                    student.setHouse(new House(file.readLine()));
                    student.setBirthday(file.readLine());
                    int numOfCourses = Integer.parseInt(file.readLine());
                    for(int i=0; i<numOfCourses; i++)
                        student.addCourse(new Course(file.readLine()));
                }
                _allStudents.add(student);
            }
            file.close();
        } catch (IOException e) {}

    }

    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("StudentDB.txt"));         // I give a different name to this file to test it 
            for (Student student : _allStudents){
                file.write(student.getName() + "\n");
                file.write(student.getSchool().getName() + "\n");
                file.write(student.getBloodStatus() + "\n");
                file.write(student.getHouse().getName() + "\n");
                file.write(student.getBirthday() + "\n");
                file.write(student.getCourses().size() + "\n");
                for(Course course : student.getCourses())
                    file.write(course.getName() + "\n");
                file.write( "*\n");
            }
            file.write( "$\n");
            file.close();

        }catch (IOException exception){}

    }

}
