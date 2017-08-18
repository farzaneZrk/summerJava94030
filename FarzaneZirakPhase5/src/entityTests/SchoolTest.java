package entityTests;

import java.util.ArrayList;
import java.util.Vector;
//import org.junit.Assert;
//import org.junit.Test;

import entities.Course;
import entities.House;
import entities.Professor;
import entities.School;
import entities.Student;

public class SchoolTest {

	private School hogwarts;

//	@Test
	public void getNameTest()
	{
		hogwarts = new School("Hogwarts");
		String expected = "Hogwarts";
		String actual = hogwarts.getName();
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void getAndSetCoursesTest()
	{   hogwarts = new School("Hogwarts");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Potions"));
		courses.add(new Course("Divination"));

		hogwarts.setCourses(courses);
		ArrayList<Course> actual = hogwarts.getCourses();
		ArrayList<Course> expected = courses;
//		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
//	@Test
	public void getAndSetHousesTest()
	{   hogwarts = new School("Hogwarts");
		ArrayList<House> houses = new ArrayList<House>();
		houses.add(new House("Gryffindor"));
		houses.add(new House("Hufflepuff"));
		houses.add(new House("Ravenclaw"));
		houses.add(new House("Slytherin"));
		hogwarts.setHouses(houses);
		ArrayList<House> actual = hogwarts.getHouses();
		ArrayList<House> expected = houses;
//		Assert.assertEquals(expected, actual);
				
	}
//	@Test
	public void getAndSetStudentsTest()
	{   hogwarts = new School("Hogwarts");
		Vector<Student> students = new Vector<Student>();
		students.add(new Student("Harry Potter"));
		students.add(new Student("Luna Lovegood"));
		students.add(new Student("Lucius Malfoy"));
		hogwarts.setStudents(students);
		
		Vector<Student> actual = hogwarts.getStudents();
		Vector<Student> expected = students;
//		Assert.assertArrayEquals(expected.toArray(), actual.toArray());		
	}
//	@Test
	public void getAndSetProfessorsTest()
	{   hogwarts = new School("Hogwarts");
		Vector<Professor> professors = new Vector<Professor>();
		professors.add(new Professor("Severus Snape"));
		professors.add(new Professor("Albus Dumbledore"));
		professors.add(new Professor("Minerva McGonnagol"));
		hogwarts.setProfessors(professors);
		
		Vector<Professor> actual = hogwarts.getProfessors();
		Vector<Professor> expected = professors;
//		Assert.assertArrayEquals(expected.toArray(), actual.toArray());

	}
}
