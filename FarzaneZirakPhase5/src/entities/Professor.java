package entities;
import java.util.*;

public class Professor extends Person{
    private Map<Integer, Course> _courses; 			/* /The list of courses and the year he/she taught them */
	private String _notes; 							/* f he/she has any special abilities or something noteworthy it is mentioned here */
	
	/*		constructor		*/

	public Professor (String name){
		this(name, new HashMap<Integer, Course>(), "");
	}
	public Professor(){
		this("");
	}
	public Professor (String name, Map<Integer, Course> courses){
		this(name, courses, "");
	}
	public Professor (String name, Map<Integer, Course> courses, String notes){
		super(name);
		_courses = courses;
		_notes = notes;
	}
	public Professor (String name, House house, BloodStatus val, School school, String birthday, Map<Integer, Course> courses, String notes){
		super(name, house, val, school, birthday);
		_courses = courses;
		_notes = notes;
	}
	/*		Getters		*/

	public Map<Integer, Course> getCourses() {
		return _courses;
	}
	public String getNotes() {
		return _notes;
	}
	/*		 Setters		*/

	public void setCourses(Map<Integer, Course> courses) {
		_courses = courses;
	}
	public void setNotes(String notes) {
		_notes = notes;
	}
	/*		Helper Methods		*/

	public void addCourse(int year, Course course){
		Integer y = new Integer(year);
		_courses.put(y, course);
	}
	public String toString(){
		String returnString = super.toString();
		returnString = "Professor" + returnString.substring(6, returnString.length()-2) + "Special abilities: " + _notes + "\n\t";
		if(!(_courses.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Courses:\n\t";
			for ( Integer key : _courses.keySet() )
				returnString = returnString + key + _courses.get(key) + "\n\t";
		}
		return returnString.substring(0, returnString.length()-1) + "}";
	}
}
