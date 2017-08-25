package entityTests;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

//import org.junit.Assert;
//import org.junit.Test;

import entities.*;

public class ProfessorTest {

	Professor snape;
//	@Test
	public void getCoursesTest()
	{
        snape = new Professor("Severus Snape");
        Course p = new Course("potions");
        Map<Integer, Course>  course = new HashMap<Integer, Course>();
        course.put(Integer.valueOf(1995), p);
        snape.setCourses(course);
		
		Map<Integer, Course>  actual = snape.getCourses();
		Map<Integer, Course>  expected = course;
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void getNotesTest() 
	{
        snape = new Professor("Severus Snape");
        snape.setNotes("Was an dead eatter!");
		String actual = snape.getNotes();
		String expected = "Was an dead eatter!";
		
//		Assert.assertEquals(expected, actual);
	}
}
