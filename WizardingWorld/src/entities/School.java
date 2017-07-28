package entities;

import java.util.*;

public class School {
	
	/*variables*/
	private String _name;
	private int _numOfStudents;
	private boolean _housed;
	private ArrayList<String> _houseNames;
	private Vector<String> _studentNames;
	private Vector<String> _professorNames;
	private ArrayList<String> _courseNames;
	/*default constructor*/
	public School(){
		_name = "";
		_numOfStudents = 0;
		_housed = false;
		_houseNames = new ArrayList<String>();
		_studentNames = new Vector<String>();
		_professorNames = new Vector<String>();
		_courseNames = new ArrayList<String>();
	}
	/*constructors*/
	public School(String name){
		this = new School();
		this.setName(name);
	}
	public School(String name, ArrayList<String> houseNames, Vector<String> studentNames, Vector<String> professorNames, ArrayList<String> courseNames){
		setName(name);
		setHouseNames(houseNames);
		setStudentNames(studentNames);
		setProfessorNames(professorNames);
		setCourseNames(courseNames);
		if (houseNames == null || houseNames.isEmpty())
			_housed = false;
		else
			_housed = true;
		if (studentNames != null)
			_numOfStudents = studentNames.size();
		else
			_numOfStudents = 0;
	}
	/*getters*/
	public String getName() {
		return _name;
	}
	public int getNumOfStudents() {
		return _numOfStudents;
	}
	public boolean isHoused() {
		return _housed;
	}
	public ArrayList<String> getHouseNames() {
		return _houseNames;
	}
	public Vector<String> getStudentNames() {
		return _studentNames;
	}
	public Vector<String> getProfessorNames() {
		return _professorNames;
	}
	public ArrayList<String> getCourseNames() {
		return _courseNames;
	}
	
	/*setters*/
	public void setName(String name) {
		_name = name;
	}
	public void setNumOfStudents(int numOfStudents) {
		_numOfStudents = numOfStudents;
	}
	public void setHoused(boolean housed) {
		_housed = housed;
	}
	public void setHouseNames(ArrayList<String> houseNames) {
		_houseNames = houseNames;
	}
	public void setStudentNames(Vector<String> studentNames){
		_studentNames = studentNames;
	}
	public void setProfessorNames(Vector<String> professorNames){
		_professorNames = professorNames;
	}
	public void setCourseNames(ArrayList<String> courseNames){
		_courseNames = courseNames;
	}
	
}
