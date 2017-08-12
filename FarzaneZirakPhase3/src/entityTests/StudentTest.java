package entityTests;

import org.junit.Assert;
import org.junit.Test;

import entities.Student;
import entities.School;
import entities.BloodStatus;
import entities.House;

public class StudentTest {

	
	Student snape;
	@Test
	public void getNameTest()
	{
		snape = new Student("Draco Malfoy");
		
		String actual = snape.getName();
		String expected = "Draco Malfoy";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getHouseTest() 
	{
		snape = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		House actual = snape.getHouse();
		House expected = new House("Slytherin");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getBloodStatusTest() 
	{
		snape = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		
		BloodStatus actual = snape.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getSchoolTest() 
	{
		snape = new Student("Draco Malfoy", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		School actual = snape.getSchool();
		School expected = new School("Hogwarts");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNameTest()
	{
		snape = new Student("");
		snape.setName("Draco Malfoy");
		String actual = snape.getName();
		String expected = "Draco Malfoy";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setHouseTest()
	{
		snape = new Student("Draco Malfoy");
		snape.setHouse(new House("Slytherin"));
		House actual = snape.getHouse();
		House expected = new House("Slytherin");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setBloodStatusTest()
	{
		snape = new Student("Draco Malfoy");
		snape.setBloodStatus(BloodStatus.Half_blood);
		BloodStatus actual = snape.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setSchoolTest()
	{
		snape = new Student("Draco Malfoy");
		snape.setSchool(new School("Hogwarts"));
		School actual = snape.getSchool();
		School expected = new School("Hogwarts");
		
		Assert.assertEquals(expected, actual);
	}

}
