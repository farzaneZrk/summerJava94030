package service;

import java.io.*;
import java.util.Vector;

import entities.*;

public class PersonService {
    private Person _person;                         // The Person the services are performed on/at
    private Vector<Person> _allPersons;             //All the persons in the system
/*      Constructors        */

    public PersonService(Person person, Vector<Person> allPersons){
        _person = person;
        _allPersons = allPersons;
    }
    public PersonService(Person person){
        this(person, null);
    }
    public PersonService(){
        this(null,null);
    }
/*      Setters        */

    public void setPerson(Person person){
        _person = person;
    }
    public void setAllPersons(Vector<Person> allPersons){
        _allPersons = allPersons;
    }
/*      Getters        */

    public Person getPerson(){
        return _person;
    }
    public Vector<Person> getAllPersons(){
        return _allPersons;
    }
/*      Helper Methods        */

    public void getData(String fileName){
        _allPersons = new Vector<Person>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;

            while (!(line = file.readLine()).equals("$")) {
                Person person = new Person(line);
                while(!(line = file.readLine()).equals("*")){
                    person.setHouse(new House(line));
                    person.setBloodStatus(BloodStatus.valueOf(file.readLine()));
                    person.setSchool(new School(file.readLine()));
                    person.setBirthday(file.readLine());
                }
                _allPersons.add(person);
            }
            file.close();
        } catch (IOException e) {}
    }
    public void setData(){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter("PersonDB.txt"));         // I give a different name to this file to test it 
            for (Person person : _allPersons){
                file.write(person.getName() + "\n");
                file.write(person.getHouse().getName() + "\n");
                file.write(person.getBloodStatus() + "\n");
                file.write(person.getSchool().getName() + "\n");
                file.write(person.getBirthday() + "\n");
                file.write( "*\n");
            }
            file.write( "$\n");
            file.close();

        }catch (IOException exception){}
    }
}
