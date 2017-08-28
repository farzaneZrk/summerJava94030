package service;

import java.io.*;
import java.util.Vector;

import entities.*;

public class FinishedCourseService {
    private Vector<FinishedCourse> _allFinishedCourses;         /* All finished courses in the system */

/*      Constructors        */

    public FinishedCourseService(Vector<FinishedCourse> allFinishedCourses){
        _allFinishedCourses = allFinishedCourses;
    }
    public FinishedCourseService(){
        this(null);
    }
/*      Setters     */

    public void setAllFinishedCourses (Vector<FinishedCourse> allFinishedCourses){
        _allFinishedCourses = allFinishedCourses;
    }
/*      Getters     */

    public Vector<FinishedCourse> getAllFinishedCourses (){
        return _allFinishedCourses;
    }
/*      Helper Methods      */

    public void getData(String fileName){
        _allFinishedCourses = new Vector<FinishedCourse>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
    
            while (!(line = file.readLine()).equals("$")) {
                FinishedCourse finishedCourse = new FinishedCourse(new Student(line));
                while(!(line = file.readLine()).equals("*")){
                    finishedCourse.setGrade(Grades.valueOf(line));
                    finishedCourse.setPassed(Boolean.parseBoolean(file.readLine()));
                    finishedCourse.setName(file.readLine());
                    finishedCourse.setMinGrade(Grades.valueOf(file.readLine()));
                    finishedCourse.setProfessor(new Professor(file.readLine()));
                    int year = Integer.parseInt(file.readLine());
                    finishedCourse.setYear(year);
                }
                _allFinishedCourses.add(finishedCourse);
            }
            file.close();
        } catch (IOException e) {}
    }
    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("myFinishedCourseDB.txt"));         // I give a different name to this file to test it 
            for (FinishedCourse finishedCourse : _allFinishedCourses){
                file.write(finishedCourse.getStudent().getName() + "\n");
                file.write(finishedCourse.getGrade() + "\n");
                file.write(finishedCourse.isPassed() + "\n");
                file.write(finishedCourse.getName() + "\n");
                file.write(finishedCourse.getMinGrade() + "\n");
                file.write(finishedCourse.getProfessor().getName() + "\n");
                file.write(finishedCourse.getYear() + "\n");
                file.write( "*\n");
            }
            file.write( "$\n");
            file.close();
    
        }catch (IOException exception){}
    }

    public Vector<FinishedCourse> getFinishedCoursesOfStudent(Student expectedStudent){
        /* The finished courses of the student inputted are returned in a vector */
        Vector<FinishedCourse> result = new Vector<FinishedCourse>();
        for(FinishedCourse finishedCourse : _allFinishedCourses){
            if (finishedCourse.getStudent().equals(expectedStudent))
                result.add(finishedCourse);
        }
        return result;
    }

    public void showAllFinishedCourses (){
     /* This method print out a string that shows all the finished courses in the system*/
     System.out.println(_allFinishedCourses);
    }

    public void showFinishedCourse(String name, Student student) {
         /* Shows the finished course specified by its name and the student taking it*/
         boolean findCourse = false;
         boolean findStudent = false;
         for(FinishedCourse finishedCourse : this.getFinishedCoursesOfStudent(student)){
             findStudent = true;
             if(finishedCourse.getName().equalsIgnoreCase(name)){
                System.out.println(finishedCourse);
                findCourse = true;
             }
         }
        if(findStudent == false)
             System.out.println("This student isn't in the system or doesn't finished any courses!");
        else if(findCourse == false && findStudent == true)
            System.out.println("This student doesn't finished this course!");
    }

    public void createNewFinishedCourse(FinishedCourse finishedCourse) {
        /* add a new finished course to the database and the vector */
        _allFinishedCourses.addElement(finishedCourse);
        setData();
        // FileWriter fStream;
        // try {
        //     fStream = new FileWriter("myFinishedCourseDB.txt", true);
        //     fStream.append(finishedCourse.toString());
        //     // fStream.append("\n");
        //     fStream.flush();
        //     fStream.close();
        // } catch (IOException ex) {}
    }

}
