package serviceTest;

import java.io.*;

import entities.Course;
import service.CourseService;

public class CourseServiceTest {

    public void runTests() throws IOException{
        // Course flying = new Course("flying");
        CourseService CSTest = new CourseService();
        CSTest.getData("CourseDB.txt");
        CSTest.setData();
        System.out.println("Get and Set data: " + compareFile("CourseDB.txt", "myCourseDB.txt"));
        // System.out.println("Get Course " + getCourseTest(CSTest, flying));
        // System.out.println("Set Course " + setCourseTest(CSTest, new Course("potions")));
    }

    public boolean getCourseTest(CourseService courseService, Course expected){
        Course actual = courseService.getCourse();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setCourseTest(CourseService courseService, Course course){
        courseService.setCourse(course);
        Course actual = courseService.getCourse();
        if(actual.equals(course))
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
