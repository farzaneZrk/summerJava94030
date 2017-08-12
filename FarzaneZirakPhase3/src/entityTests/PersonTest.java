package entityTests;

import org.junit.Assert;
import org.junit.Test;

import entities.Person;
import entities.School;
import entities.BloodStatus;
import entities.House;

public class PersonTest {

	
	Person snape;
	@Test
	public void getNameTest()
	{
		snape = new Person("Severus Snape");
		
		String actual = snape.getName();
		String expected = "Severus Snape";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getHouseTest() 
	{
		snape = new Person("Severus Snape", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		House actual = snape.getHouse();
		House expected = new House("Slytherin");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getBloodStatusTest() 
	{
		snape = new Person("Severus Snape", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		
		BloodStatus actual = snape.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void getSchoolTest() 
	{
		snape = new Person("Severus Snape", new House("Slytherin"), BloodStatus.Half_blood, new School("Hogwarts"), "9-01-1960");
		School actual = snape.getSchool();
		School expected = new School("Hogwarts");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setNameTest()
	{
		snape = new Person("");
		snape.setName("Severus Snape");
		String actual = snape.getName();
		String expected = "Severus Snape";
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setHouseTest()
	{
		snape = new Person("Severus Snape");
		snape.setHouse(new House("Slytherin"));
		House actual = snape.getHouse();
		House expected = new House("Slytherin");
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setBloodStatusTest()
	{
		snape = new Person("Severus Snape");
		snape.setBloodStatus(BloodStatus.Half_blood);
		BloodStatus actual = snape.getBloodStatus();
		BloodStatus expected = BloodStatus.Half_blood;
		
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void setSchoolTest()
	{
		snape = new Person("Severus Snape");
		snape.setSchool(new School("Hogwarts"));
		School actual = snape.getSchool();
		School expected = new School("Hogwarts");
		
		Assert.assertEquals(expected, actual);
	}

}
