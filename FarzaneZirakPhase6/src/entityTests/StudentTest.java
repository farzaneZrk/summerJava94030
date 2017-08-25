package entityTests;

//import org.junit.Assert;
//import org.junit.Test;

import entities.Student;
import entities.School;
import entities.BloodStatus;
import entities.House;

public class StudentTest {

	
	Student Draco;
//	@Test
	public void getNameTest()
	{
		Draco = new Student("Draco Malfoy");
		
		String actual = Draco.getName();
		String expected = "Draco Malfoy";
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void getHouseTest() 
	{
		Draco = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		House actual = Draco.getHouse();
		House expected = new House("Slytherin");
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void getBloodStatusTest() 
	{
		Draco = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		
		BloodStatus actual = Draco.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void getSchoolTest() 
	{
		Draco = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		School actual = Draco.getSchool();
		School expected = new School("Hogwarts");
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void setNameTest()
	{
		Draco = new Student("");
		Draco.setName("Draco Malfoy");
		String actual = Draco.getName();
		String expected = "Draco Malfoy";
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void setHouseTest()
	{
		Draco = new Student("Draco Malfoy");
		Draco.setHouse(new House("Slytherin"));
		House actual = Draco.getHouse();
		House expected = new House("Slytherin");
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void setBloodStatusTest()
	{
		Draco = new Student("Draco Malfoy");
		Draco.setBloodStatus(BloodStatus.Half_blood);
		BloodStatus actual = Draco.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
//		Assert.assertEquals(expected, actual);
	}
//	@Test
	public void setSchoolTest()
	{
		Draco = new Student("Draco Malfoy");
		Draco.setSchool(new School("Hogwarts"));
		School actual = Draco.getSchool();
		School expected = new School("Hogwarts");
		
//		Assert.assertEquals(expected, actual);
	}

}
