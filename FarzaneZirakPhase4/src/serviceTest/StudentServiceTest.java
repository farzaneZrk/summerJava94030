package serviceTest;

import entities.House;
import entities.Student;
import service.StudentService;

public class StudentServiceTest {
    public void runTests(){
        Student harry = new Student("Harry Potter");
        StudentService SSTest = new StudentService(harry);
        
        System.out.println("Get Student: " + getStudentTest(SSTest, harry));
        System.out.println("Set Student: " + setStudentTest(SSTest, new Student("Deraco Malfoy")));
        System.out.println("Sort To House: " + sortToHouseTest(SSTest, new House("Slytherin")));
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

    
}
