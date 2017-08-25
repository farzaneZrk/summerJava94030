package serviceTest;

import java.io.*;

import entities.Student;
import service.FinishedCourseService;

public class FinishedCourseServiceTest {
    public void runTests() throws IOException{
        FinishedCourseService FCSTest = new FinishedCourseService();
        FCSTest.getData("FinishedCourseDB.txt");
        FCSTest.setData();
        System.out.println("Get and Set data: " + compareFile("FinishedCourseDB.txt", "myFinishedCourseDB.txt"));
        // System.out.println(FCSTest.getAllFinishedCourses());
        getFinishedCoursesOfStudentTest(FCSTest, new Student("Harry Potter"));
    }

    public void getFinishedCoursesOfStudentTest(FinishedCourseService fcs, Student student){
        System.out.println(fcs.getFinishedCoursesOfStudent(student));
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
