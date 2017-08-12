package entities;
import java.util.Vector;

public class Student extends Person {
    private Vector<Course> _courses;
	private Vector<FinishedCourse> _reportCard;
	
	/*constructor*/
	public Student(String name){
		super(name);
		_courses = new Vector<Course>();
		_reportCard = new Vector<FinishedCourse>();
	}
	public Student(){
		this("");
	}
	public Student(String name, Vector<Course> courses, Vector<FinishedCourse> reportCard){
		super(name);
		_courses = courses;
		_reportCard = reportCard;
	}
	public Student(String name, House house, BloodStatus val, School school, String birthday){
		super(name, house, val, school, birthday);
		_courses = new Vector<Course>();
		_reportCard = new Vector<FinishedCourse>();
	}
	public Student(String name, House house, BloodStatus val, School school, String birthday,
	Vector<Course> courses, Vector<FinishedCourse> reportCard){
		super(name, house, val, school, birthday);
		_courses = courses;
		_reportCard = reportCard;
	}
	public Vector<Course> getCourses() {
		return _courses;
	}
	public void setCourses(Vector<Course> courses) {
		_courses = courses;
	}
	public Vector<FinishedCourse> getReportCard() {
		return _reportCard;
	}
	public void setReportCard(Vector<FinishedCourse> reportCard) {
		_reportCard = reportCard;
	}
	/*Methods*/
	public void addCourse(Course course){
		_courses.add(course);
	}
	public void addToReportCard(FinishedCourse finishedCourse){
		_reportCard.add(finishedCourse);
	}
	public String toString(){
		String returnString = super.toString();
		returnString = "Student" + returnString.substring(6, returnString.length()-1) + "\t";
		if(!(_courses.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Courses:\n\t";
			for(int i=0; i<_courses.size(); i++)
				returnString += _courses.elementAt(i).getName() + "\n\t";
		}
		if(!(_reportCard.isEmpty())){
			returnString = returnString.substring(0, returnString.length()-1) + "Finished Courses:\n\t";
			for(int i=0; i<_reportCard.size(); i++)
				returnString += _reportCard.elementAt(i).getName() + "\n\t";
		}
		return returnString.substring(0, returnString.length()-1) + "}";
	}
}

