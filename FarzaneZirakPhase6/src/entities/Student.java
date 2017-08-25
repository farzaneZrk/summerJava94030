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
	public boolean equals(Student student){
		if(!(_name.equals(student.getName())))
			return false;
		else if(_house != null && student.getHouse() != null && !_house.equals(student.getHouse()))
			return false;
		else if(!(_bloodStatus.equals(student.getBloodStatus())))
			return false;
			else if(_school != null && student.getSchool() != null && !_school.equals(student.getSchool()))
			return false;
		else if(!(_birthday.equals(student.getBirthday())))
			return false;
		else if (_courses != null && student.getCourses() != null && !_courses.equals(student.getCourses()))
			return false;
		else if (_reportCard != null && student.getReportCard() != null && !_reportCard.equals(student.getReportCard()))
			return false;
		
		return true;
	}
	public String toString(){
		return  "\n" + _name + "\n" +
				_house.getName() + "\n" +
				_bloodStatus + "\n" +
				_school.getName() + "\n" +
				_birthday + "\n" ;

	}
}

