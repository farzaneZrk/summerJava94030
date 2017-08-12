package entities;
import entities.Student;
import java.util.ArrayList;
import java.util.Vector;


public class School {

	/*Variables*/
	private String _name;
	private int _numOfStudents;
	private boolean _housed;
	private ArrayList<House> _houses;
	private ArrayList<Course> _courses;
    private Vector<Student> _students;
	private Vector<Professor> _professors;
	private String _location;
	
	/*Constructors*/
	public School(String name){
		_name = name;
		_numOfStudents = 0;
		_housed = false;
		_houses = new ArrayList<House>();
		_students = new Vector<Student>();
		_professors = new Vector<Professor>();
		_courses = new ArrayList<Course>();
	}
	public School(){
		this("");
	}
	public School(String name, ArrayList<House> houses, ArrayList<Course> courseNames,
			Vector<Student> students, Vector<Professor> professors){
		setName(name);
		setHouses(houses);
		setStudents(students);
		setProfessors(professors);
		setCourses(courseNames);
		if (houses == null || houses.isEmpty())
			_housed = false;
		else
			_housed = true;
		if (students != null)
			_numOfStudents = students.size();
		else
			_numOfStudents = 0;
	}
	/*Getters*/
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
	public ArrayList<Course> getCourseNames() {
		return _courses;
	}
	/*Setters*/
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
	/*Methods*/
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
