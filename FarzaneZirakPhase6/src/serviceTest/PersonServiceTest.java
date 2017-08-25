package serviceTest;
import java.io.*;

import entities.*;
import service.PersonService;

public class PersonServiceTest {

    public void runTests() throws IOException{
        
        PersonService PSTest = new PersonService();
        
        Person harry = new Person("Harry Poter");
        PSTest.setPerson(harry);
        PSTest.getData("PersonDB.txt");
        PSTest.setData();

        System.out.println("Get Person " + getPersonTest(PSTest, harry));
        System.out.println("Set Person " + setPersonTest(PSTest, new Person("Deraco Malfoy")));
        System.out.println("Get and Set data " + compareFile("PersonDB.txt", "myPersonDB.txt"));
    }

    public boolean getPersonTest(PersonService personService, Person expected){
        Person actual = personService.getPerson();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setPersonTest(PersonService personService, Person person){
        personService.setPerson(person);
        Person actual = personService.getPerson();
        if(actual.equals(person))
            return true;
        return false;
    }

    public boolean compareFile(String file1, String file2)throws IOException {

        BufferedReader reader1 = new BufferedReader(new FileReader(new File(file1)));
        BufferedReader reader2 = new BufferedReader(new FileReader(new File(file2)));
        String line1, line2;
        boolean result ;
        while (true){ 
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            if (line1 == null){ 
                result = (line2 == null ? true : false);
                break;
            } 
            if (!line1.equalsIgnoreCase(line2)){ 
                result = false;
                break;
            }
        }  
        reader1.close();
        reader2.close();
        return result;
    }


}
