package serviceTest;

import java.io.*;
import java.util.ArrayList;

import entities.*;
import service.SchoolService;

public class SchoolServiceTest {
    public void runTests() throws IOException{
        SchoolService SSTest = new SchoolService();
        SSTest.getData("SchoolDB.txt");
        SSTest.setData();
        System.out.println("Get and Set data " + compareFile("SchoolDB.txt", "mySchoolDB.txt"));
        
        // School hagwarts = new School("Hagwarts");
        // Student deraco = new Student("Deraco Malfoy");
        // ArrayList<House> houses = new ArrayList<House>();
		// houses.add(new House("Gryffindor"));
		// houses.add(new House("Hufflepuff"));
		// houses.add(new House("Ravenclaw"));
		// houses.add(new House("Slytherin"));
        // hagwarts.setHouses(houses);
        
        // System.out.println("Get School " + getSchoolTest(SSTest, hagwarts));
        // System.out.println("Set School " + setSchoolTest(SSTest, new School("potions")));
        // System.out.println("Sorting Hat " + sortingHatTest(SSTest, deraco, houses.get(3)));
    }

    public boolean getSchoolTest(SchoolService SchoolService, School expected){
        School actual = SchoolService.getSchool();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setSchoolTest(SchoolService SchoolService, School School){
        SchoolService.setSchool(School);
        School actual = SchoolService.getSchool();
        if(actual.equals(School))
            return true;
        return false;
    }

    public boolean sortingHatTest(SchoolService schoolService, Student student, House house) throws IOException{
        House actual = schoolService.sortingHat(student);
        if(actual.equals(house))
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
