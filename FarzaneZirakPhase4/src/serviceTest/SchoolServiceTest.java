package serviceTest;

import java.io.IOException;
import java.util.ArrayList;

import entities.House;
import entities.School;
import entities.Student;
import service.SchoolService;

public class SchoolServiceTest {
    public void runTests() throws IOException{
        School hagwarts = new School("Hagwarts");
        Student deraco = new Student("Deraco Malfoy");
        ArrayList<House> houses = new ArrayList<House>();
		houses.add(new House("Gryffindor"));
		houses.add(new House("Hufflepuff"));
		houses.add(new House("Ravenclaw"));
		houses.add(new House("Slytherin"));
        hagwarts.setHouses(houses);
        SchoolService SSTest = new SchoolService(hagwarts);
        
        System.out.println("Get School " + getSchoolTest(SSTest, hagwarts));
        System.out.println("Set School " + setSchoolTest(SSTest, new School("potions")));
        System.out.println("Sorting Hat " + sortingHatTest(SSTest, deraco, houses.get(3)));
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
}
