package service;

import java.io.*;
import java.util.Vector;

import entities.*;

public class HouseService {
    private House _house;                              /* The house the services are performed on/at */
    private Vector<House> _allHouses;                  /* All the houses in the system */

/*      Constructors        */
    public HouseService(House house, Vector<House> allHouses){
        _house = house;
        _allHouses = allHouses;
    }   
    public HouseService(House house){
        this(house,null);
    } 
    public HouseService(){
        this(null,null);
    }

/*      Setters        */
    public void setHouse(House house){
        _house = house;
    }
    public void setAllHouses(Vector<House> allHouses){
        _allHouses = allHouses;
    }

/*      Getters        */
    public House getHouse(){
        return _house;
    }
    public Vector<House> getAllHouses(){
        return _allHouses;
    }
/*      Helper Methods        */

    public void getData(String fileName){
        _allHouses = new Vector<House>();
        try{
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
            while(!(line = file.readLine()).equals("$")){
                House house = new House(line);
                while(!(line = file.readLine()).equals("*")){
                    house.setSchool(new School(line));
                    int numOfStudents = Integer.parseInt(file.readLine());
                    for(int i=0; i<numOfStudents; i++)
                        house.addStudent(new Student(file.readLine()));
                }
                _allHouses.add(house);
            }
            file.close();
        } catch(Exception e){}
    }

    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("HouseDB.txt"));
            for(House house : _allHouses){
                file.write(house.getName() + "\n");
                file.write(house.getSchool().getName() + "\n");
                file.write(house.getStudents().size() + "\n");
                for(Student student : house.getStudents())
                    file.write(student.getName() + "\n");
                file.write("*\n");
            }
            file.write("$\n");
            file.close();
            
        } catch(Exception e){}
    }

}
