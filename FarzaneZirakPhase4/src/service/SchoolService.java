package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

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

    public House sortingHat(Student student) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        Vector<Vector<String>> questions = getQuestions();   

        System.out.println("Enter a number:     ");
        int key = Integer.parseInt(br.readLine());
        System.out.println("now just type the number of your answer then press Enter. " + key);

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
                Vector<String> vec = new Vector<String>();
        
                while ((s = file.readLine()) != null) {
                    vec.add(s);
                    s = file.readLine();
                    int num = Integer.parseInt(s);
                    for(int i = 0; i < num; i++){
                        s = file.readLine();
                        vec.add(s);
                    }
                    vc.add(vec);
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
