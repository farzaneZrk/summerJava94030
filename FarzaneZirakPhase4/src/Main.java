import java.io.IOException;

import service.SchoolService;
import serviceTest.CourseServiceTest;
import serviceTest.SchoolServiceTest;
import serviceTest.StudentServiceTest;

public class Main {
	public static void main(String args[]) throws IOException{
//        CourseServiceTest CSTest = new CourseServiceTest();
//        CSTest.runTests();
//        StudentServiceTest SSTest = new StudentServiceTest();
//        SSTest.runTests();
        SchoolServiceTest SCSTest = new SchoolServiceTest();
        SCSTest.runTests();


//         SchoolService ss = new SchoolService();
//         ss.getQuestions();
	}
}
