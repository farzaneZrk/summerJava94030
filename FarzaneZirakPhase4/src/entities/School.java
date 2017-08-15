package entities;
import entities.Student;
import java.util.ArrayList;
import java.util.Vector;


public class School {

	/*		Variables	*/
	private String _name;						/* The school's name */
	private int _numOfStudents; 				/*Number of students attending the school */
	private boolean _housed;					/* A school may or may not have houses */
	private String _location; 					/* This string specifies which country the school is located at */	
	private ArrayList<House> _houses; 			/* Vector of houses which the school has */
	private ArrayList<Course> _courses; 		/*  This vector contains the information of courses offered */
    private Vector<Student> _students; 			/* This vector contains the information of students attending */
	private Vector<Professor> _professors; 		/* This vector contains the information of professors teaching */
	
	/*		Constructors	*/
	
	public School(String name, int numOfStudents, boolean housed, ArrayList<House> houses,
			Vector<Student> students, Vector<Professor> professors, ArrayList<Course> courses, String location){
		_name = name;
		_numOfStudents = numOfStudents;
		_housed = housed;
		_houses = houses;
		_students = students;
		_professors = professors;
		_courses = courses;
		_location = location;
				
	}
	public School(String name, String location, ArrayList<House> houses, ArrayList<Course> courses,
			Vector<Student> students, Vector<Professor> professors){
		_name = name;
		_location = location;
		_students = students;
		_professors = professors;
		_courses = courses;
		if (houses == null || houses.isEmpty())
			_housed = false;
		else
			_housed = true;
		if (students != null)
			_numOfStudents = students.size();
		else
			_numOfStudents = 0;
	}
	public School(String name, boolean housed, String location){
		this(name, 0, housed, new ArrayList<House>(), 
				new Vector<Student>(), new Vector<Professor>(), new ArrayList<Course>(), location);
	}
	public School(String name){
		this(name, "", new ArrayList<House>(), new ArrayList<Course>(), new Vector<Student>(), new Vector<Professor>());
	}
	public School(){
		this("");
	}
	/*		Getters		*/
	public String getName() {
		return _name;
	}
	public int getnumOfStudents() {
		return _numOfStudents;
	}
	public boolean isHoused() {
		return _housed;
	}
	public ArrayList<House> getHouses() {
		return _houses;
	}
	public Vector<Student> getStudents() {
		return _students;
	}
	public Vector<Professor> getProfessors() {
		return _professors;
	}
	public ArrayList<Course> getCourses() {
		return _courses;
	}
	/*		Setters		*/
	public void setName(String name) {
		_name = name;
	}
	public void setnumOfStudents(int numOfStudents) {
		_numOfStudents = numOfStudents;
	}
	public void setHoused(boolean housed) {
		_housed = housed;
	}
	public void setHouses(ArrayList<House> houses) {
		_houses = houses;
	}
	public void setStudents(Vector<Student> students){
		_students = students;
	}
	public void setProfessors(Vector<Professor> professors){
		_professors = professors;
	}
	public void setCourses(ArrayList<Course> courses){
		_courses = courses;
	}
	public String getLocation() {
		return _location;
	}
	public void setLocation(String location) {
		_location = location;
	}
	/*		Helper Methods		*/
	public void addHouse(House house){
		_houses.add(house);
	}
	public void addCourse(Course course){
		_courses.add(course);
	}
	public void addStudent(Student student){
		_students.add(student);
	}
	public void addProfessor(Professor professor){
		_professors.add(professor);
	}
	public String halfToString(){
		String returString = "School{\nname: " + _name + "\nNumber of students:" + _numOfStudents + "\nLocation: " + _location + "\n";
		if(_housed)
			return returString + "Is Housed.\n";
		else
			return returString + "Is not Housed.\n";
	}
	public String toString(){
		String returnString = this.halfToString() + "\t";
		if(!(_houses.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Houses:\n\t";
			for(int i=0; i<_houses.size(); i++)
				returnString += _houses.get(i).getName() + "\n\t";
		}
		if(!(_courses.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Courses:\n\t";
			for(int i=0; i<_courses.size(); i++)
				returnString += _courses.get(i).getName() + "\n\t";
		}
		if(!(_students.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Students:\n\t";
			for(int i=0; i<_students.size(); i++)
				returnString += _students.elementAt(i).getName() + "\n\t";
		}
		if(!(_professors.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Professors:\n\t";
			for(int i=0; i<_professors.size(); i++)
				returnString += _professors.elementAt(i).getName() + "\n\t";
		}
		return returnString.substring(0, returnString.length()-1) + "}";
	}
	
}

