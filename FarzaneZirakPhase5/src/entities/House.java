package entities;
import entities.School;
import entities.Student;
import entities.Professor;
import java.util.*;
public class House {
    private String _name;							/* House name */
    private School _school;							/* The school that has this house */
    private Vector<Student> _students;				/* List of students in the house */
    private Professor _headTeacher;					/* The house's head teacher */
    private Vector<String> _qualities;				/* List of qualities that are required to be in the house */
	private Map<Integer, Student> _prefects;		/* The list of prefects of the house per year */
	
	/*		constructor		*/
	
	public House(String name, School school, Vector<Student> students, Professor headTeacher, Vector<String> qualities, Map<Integer, Student> prefects){
		_name = name;
		_school = school;
		_headTeacher = headTeacher;
		_students = students;
		_qualities = qualities;
		_prefects = prefects;
	}
	public House(String name){
		this(name, null, new Vector<Student>(), null, new Vector<String>(), new HashMap<Integer, Student>());
	}
	public House(){
		this("");
	}
	public House(String name, School school, Professor headTeacher){
		this(name, school, new Vector<Student>(), headTeacher, new Vector<String>(), new HashMap<Integer, Student>());
	}
	public House(String name, School school, Vector<Student> students, Professor headTeacher){
		this(name, school, students, headTeacher, new Vector<String>(), new HashMap<Integer, Student>());
	}
	/*		Setters		*/

	public void setName(String name) {
		_name = name;
	}
	public void setSchool(School school) {
		_school = school;
	}
	public void setStudents(Vector<Student> students) {
		_students = students;
	}
	public void setHeadTeacher(Professor headTeacher) {
		_headTeacher = headTeacher;
	}
	public void setQualities(Vector<String> qualities) {
		_qualities = qualities;
	}
	public void setPrefects(Map<Integer, Student> prefects) {
		_prefects = prefects;
	}
	/*		Getters		*/

	public String getName() {
		return _name;
	}
	public School getSchool() {
		return _school;
	}
	public Vector<Student> getStudents() {
		return _students;
	}
	public Professor getHeadTeacher() {
		return _headTeacher;
	}
	public Vector<String> getQualities() {
		return _qualities;
	}
	public Map<Integer, Student> getPrefects() {
		return _prefects;
	}
	/*		Helper Methods		*/
	
	public void addQuality(String quality){
		_qualities.add(quality);
	}
	public void addStudent(Student student){
		_students.add(student);
	}
	public void addPrefect(int year, Student prefect){
		Integer y = new Integer(year);
		_prefects.put(y, prefect);
	}

	public String toString(){
		return "House{\nName: " + _name + "School: " + _school.getName()
				+"Head Teacher: Professor " + _headTeacher.getName();
	}
	public String fullyToString(){
		String returnString = this.toString().substring(0, this.toString().length()-1) + "\n\t";
		if(!(_students.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Students:\n\t";
			for(int i=0; i<_students.size(); i++)
				returnString += _students.elementAt(i).getName() + "\n\t";
		}
		if(!(_qualities.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Qualities:\n\t";
			for(int i=0; i<_qualities.size(); i++)
				returnString += _qualities.elementAt(i) + "\n\t";
		}
		if(!(_prefects.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Prefects:\n\t";
			for ( Integer key : _prefects.keySet() )
				returnString = returnString + key.intValue() + "\t" + _prefects.get(key) + "\n\t"; ////////////////////////danger
		}
		return returnString.substring(0, returnString.length()-1) + "}";
	}
}