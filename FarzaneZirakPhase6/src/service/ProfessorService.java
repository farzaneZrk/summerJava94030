package service;

import java.io.*;
import java.util.*;


import entities.*;

public class ProfessorService {

    private Professor _professor;                         // The professor the services are performed on/at
    private Vector<Professor> _allProfessors;             //All the professors in the system
/*      Constructors        */

    public ProfessorService(Professor professor, Vector<Professor> allProfessors){
        _professor = professor;
        _allProfessors = allProfessors;
    }
    public ProfessorService(Professor professor){
        this(professor, null);
    }
    public ProfessorService(){
        this(null,null);
    }
/*      Setters        */

    public void setProfessor(Professor professor){
        _professor = professor;
    }
    public void setAllProfessors(Vector<Professor> allProfessors){
        _allProfessors = allProfessors;
    }
/*      Getters        */

    public Professor getProfessor(){
        return _professor;
    }
    public Vector<Professor> getAllProfessors(){
        return _allProfessors;
    }
/*      Helper Methods        */

    public void getData(String fileName){
        _allProfessors = new Vector<Professor>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;

            while (!(line = file.readLine()).equals("$")) {
                Professor professor = new Professor(line);
                while(!(line = file.readLine()).equals("*")){
                    professor.setHouse(new House(line));
                    professor.setBloodStatus(BloodStatus.valueOf(file.readLine()));
                    professor.setSchool(new School(file.readLine()));
                    professor.setBirthday(file.readLine());
                    Course course = new Course(file.readLine());
                    Integer year = new Integer(file.readLine());
                    professor.addCourse(year, course);
                    professor.setNotes(file.readLine());
                }
                _allProfessors.add(professor);
            }
            file.close();
        } catch (IOException e) {}
    }
    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("ProfessorDB.txt"));         // I give a different name to this file to test it 
            for (Professor professor : _allProfessors){
                file.write(professor.getName() + "\n");
                file.write(professor.getHouse().getName() + "\n");
                file.write(professor.getBloodStatus() + "\n");
                file.write(professor.getSchool().getName() + "\n");
                file.write(professor.getBirthday() + "\n");
                Map<Integer, Course> _courses =  professor.getCourses();
                for ( Integer key : _courses.keySet() ){
                    file.write(_courses.get(key).getName() + "\n");
                    file.write(key + "\n");
                }
                file.write(professor.getNotes() + "\n");
                file.write( "*\n");
            }
            file.write( "$\n");
            file.close();

        }catch (IOException exception){}
    }


}
