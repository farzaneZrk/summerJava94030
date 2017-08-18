package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import entities.Course;
import entities.House;
import entities.Professor;
import entities.School;
import entities.Student;

public class SchoolService {
    private School _school;                     /* The school the services are performed on/at */
    private Vector<School> _allSchools;          /* All the schools in the system */

/*      Constructors        */

    public SchoolService(School school, Vector<School> allSchools){
        _school = school;
        _allSchools = allSchools;
    }
    public SchoolService(School school){
        this(school, null);
    }
    public SchoolService(){
        this(null);
    }
/*      Setters        */

    public void setSchool(School school){
        _school = school;
    }
    public void setAllSchools(Vector<School> allSchools){
        _allSchools = allSchools;
    }
/*      Setters        */

    public School getSchool(){
        return _school;
    }
    public Vector<School> getAllSchools(){
        return _allSchools;
    }

/*      Helper Methods        */

    public void getData(String fileName){
    	_allSchools = new Vector<School>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
    
            while (!(line = file.readLine()).equals("$")) {
                School school = new School(line);
                while(!(line = file.readLine()).equals("*")){
                    int numOfHouses = Integer.parseInt(line);
                    for(int i=0; i<numOfHouses; i++){
                        House house = new House(file.readLine());
                        school.addHouse(house);
                    }
                    int numOfStudents = Integer.parseInt(file.readLine());
                    for(int i=0; i<numOfStudents; i++){
                        Student student = new Student(file.readLine());
                        school.addStudent(student);
                    }
                    int numOfProfessors =  Integer.parseInt(file.readLine());
                    for(int i=0; i<numOfProfessors; i++){
                        Professor professor = new Professor(file.readLine());
                        school.addProfessor(professor);
                    }
                    int numOfCourses =  Integer.parseInt(file.readLine());
                    for(int i=0; i<numOfCourses; i++){
                        Course course = new Course(file.readLine());
                        school.addCourse(course);
                    }
                    school.setLocation(file.readLine());
                }
                _allSchools.add(school);
            }
            file.close();
        } catch (IOException e) {}

    }

    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("mySchoolDB.txt"));
            for (School school : _allSchools){
            	if(school == null)
            		break;
                file.write(school.getName() + "\n");
                if(school.getHouses() != null){
                    file.write(school.getHouses().size() + "\n");
                    for(House house : school.getHouses())
                        file.write(house.getName() + "\n");
                }
                else
                    file.write("0\n");
                file.write(school.getnumOfStudents() + "\n");
                for(Student student : school.getStudents())
                    file.write(student.getName() + "\n");
                file.write(school.getProfessors().size() + "\n");
                for(Professor professor  : school.getProfessors())
                    file.write(professor.getName() + "\n");
                file.write(school.getCourses().size() + "\n");
                for(Course course : school.getCourses())
                    file.write(course.getName() + "\n");
                file.write(school.getLocation() + "\n");
                file.write( "*\n");

            }
            file.write( "$\n");
            file.close();

        }catch (IOException exception){}

    }

    public House sortingHat(Student student) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        Vector<Vector<String>> questions = getQuestions();
        System.out.println("Enter a number (1 or 2):     ");
        int key = Integer.parseInt(br.readLine());
        System.out.println("now just type the number of your answer then press Enter. ");

        for(int i=0; i<8 ; i++){
            for(int j=0; j<questions.get(i*key).size(); j++)
                System.out.println(questions.get(i*key).get(j));
            int answer = Integer.parseInt(br.readLine());
            score += answer;
        }
        House result = chooseHouse(score);
        System.out.println("Your house is :     " + result.getName());
        StudentService ss = new StudentService(student);
        ss.sortToHouse(result);
        return result;
        
    }
    
    public Vector<Vector<String>> getQuestions(){
        Vector<Vector<String>> vc = new Vector<Vector<String>>();
        
            try {
                BufferedReader file = new BufferedReader(new FileReader("questions.txt"));
                String s;
        
                while ((s = file.readLine()) != null) {
                    Vector<String> vec = new Vector<String>();
                    vec.addElement(s);
                    s = file.readLine();
                    int num = Integer.parseInt(s);
                    for(int i = 0; i < num; i++){
                        s = file.readLine();
                        vec.addElement(s);
                    }
                    vc.addElement(vec);
                }
                file.close();
            } catch (IOException e) {}
        return vc;
    }

    public House chooseHouse(int score){
        int board = score / _school.getHouses().size();
        int y = board;
        House house = _school.getHouses().get(0);
        for(int i=0; i<_school.getHouses().size(); i++ ){
            if ((score - (i*board)) < y){
                y = score - (i*board);
                house = _school.getHouses().get(i);
            }
        } 
        return house;
    }
}
