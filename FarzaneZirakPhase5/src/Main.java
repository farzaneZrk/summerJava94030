
import java.io.*;

import serviceTest.SchoolServiceTest;

public class Main {
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
	public static void main(String args[]) throws IOException{
//      CourseServiceTest CSTest = new CourseServiceTest();
//      CSTest.runTests();
//      StudentServiceTest SSTest = new StudentServiceTest();
//      SSTest.runTests();
      SchoolServiceTest SCSTest = new SchoolServiceTest();
      SCSTest.runTests();


//       SchoolService ss = new SchoolService();
//       ss.getQuestions();
	}
}
