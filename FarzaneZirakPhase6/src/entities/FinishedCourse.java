package entities;

public class FinishedCourse extends Course {
	private Student _student;		/* The student that the course is belong to */
    private Grades _grade;			/*Grade received*/
	private boolean _passed;		/* Whether or not the student passed the course */
	
	/*		constructor		*/

	public FinishedCourse (String name, Grades minGrade, Professor professor, int year, Student student, Grades grade, boolean passed) {
		super(name, professor, minGrade, year);
		_student = student;
		_grade = grade;
		_passed = passed;
	}
	public FinishedCourse (String name, Grades minGrade, Professor professor, int year, Grades grade) {
		this(name, minGrade, professor, year, null, grade, minGrade.isBetter(grade));
	}
	public FinishedCourse (String name, Student student, Grades grade, boolean passed) {
		super(name);
		_student = student;
		_grade = grade;
		_passed = passed;
	}
	public FinishedCourse (Student student) {
		this("", student , Grades.Default, false);
	}
	public FinishedCourse (String name) {
		this(name, null , Grades.Default, false);
	}
	public FinishedCourse () {
		this("");
	}
	/*		Getters		*/

	public Student getStudent(){
		return _student;
	}
	public Grades getGrade() {
		return _grade;
	}
	public boolean isPassed() {
		return _passed;
	}
	/*		Setters		*/

	public void setStudent(Student student){
		_student = student;
	}
	public void setGrade(Grades grade) {
		_grade = grade;
	}
	public void setPassed(boolean passed) {
		_passed = passed;
	}
	/*		Helper Methods		*/

	public String toString(){
		String returnString = "Finished" + super.toString() + "Grade: " + _grade + "\n";
		if(_passed)
			return returnString + "Passed}";
		else
			return returnString + "Faild}";
	}
    
}
