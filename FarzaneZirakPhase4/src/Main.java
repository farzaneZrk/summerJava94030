import serviceTest.CourseServiceTest;
import serviceTest.StudentServiceTest;

public class Main {
	public static void main(String args[]){
        CourseServiceTest CSTest = new CourseServiceTest();
        CSTest.runTests();
        StudentServiceTest SSTest = new StudentServiceTest();
        SSTest.runTests();
	}
}
