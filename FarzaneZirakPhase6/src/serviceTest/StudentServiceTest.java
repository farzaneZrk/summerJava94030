package serviceTest;

import java.io.*;

import entities.House;
import entities.Student;
import service.StudentService;

public class StudentServiceTest {
    public void runTests() throws IOException{
        // Student harry = new Student("Harry Potter");
        StudentService SSTest = new StudentService();
        SSTest.getData("StudentDB.txt");
        SSTest.setData();
        System.out.println("Get and Set data: " + compareFile("StudentDB.txt", "myStudentDB.txt"));
        // System.out.println("Get Student: " + getStudentTest(SSTest, harry));
        // System.out.println("Set Student: " + setStudentTest(SSTest, new Student("Deraco Malfoy")));
        // System.out.println("Sort To House: " + sortToHouseTest(SSTest, new House("Slytherin")));
    }

    public boolean getStudentTest(StudentService StudentService, Student expected){
        Student actual = StudentService.getStudent();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setStudentTest(StudentService StudentService, Student student){
        StudentService.setStudent(student);
        Student actual = StudentService.getStudent();
        if(actual.equals(student))
            return true;
        return false;
    }

    public boolean sortToHouseTest(StudentService studentService, House house){
        studentService.sortToHouse(house);
        House actual1 = studentService.getStudent().getHouse();
        Student actual2 = house.getStudents().lastElement();
        if (actual1.equals(house) && actual2.equals(studentService.getStudent()))
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
