package entities;
import java.util.Vector;

public class Student extends Person {
    private Vector<Course> _courses;					/*The courses the student has taken */
	private Vector<FinishedCourse> _reportCard;			/*The student's report card */
	
	/*		constructor		*/

	public Student(String name, House house, BloodStatus val, School school, String birthday,
	Vector<Course> courses, Vector<FinishedCourse> reportCard){
		super(name, house, val, school, birthday);
		_courses = courses;
		_reportCard = reportCard;
	}
	public Student(String name, House house, BloodStatus val, School school, String birthday){
		this(name, house, val, school, birthday, new Vector<Course>(), new Vector<FinishedCourse>());
	}
	public Student(String name, Vector<Course> courses, Vector<FinishedCourse> reportCard){
		super(name);
		_courses = courses;
		_reportCard = reportCard;
	}
	public Student(String name){
		this(name, new Vector<Course>(), new Vector<FinishedCourse>());
	}
	public Student(){
		this("");
	}
	/*		Getters		*/
	public Vector<Course> getCourses() {
		return _courses;
	}
	public Vector<FinishedCourse> getReportCard() {
		return _reportCard;
	}
	/*		Setters		*/

	public void setCourses(Vector<Course> courses) {
		_courses = courses;
	}
	public void setReportCard(Vector<FinishedCourse> reportCard) {
		_reportCard = reportCard;
	}
	/*		Helper Methods		*/
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

