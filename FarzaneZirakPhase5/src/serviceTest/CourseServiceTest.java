package serviceTest;

import entities.Course;
import service.CourseService;

public class CourseServiceTest {

    public void runTests(){
        Course flying = new Course("flying");
        CourseService CSTest = new CourseService(flying);
        
        System.out.println("Get Course " + getCourseTest(CSTest, flying));
        System.out.println("Set Course " + setCourseTest(CSTest, new Course("potions")));
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
}
