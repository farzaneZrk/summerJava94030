package entities;
import java.util.Vector;
public class FinishedCourse extends Course {
    private Grades _grade;
	private boolean _passed;
	
	/*constructor*/
	public FinishedCourse (String name, Grades minGrade, Professor professor, int year, Grades grade) {
		super(name, professor, minGrade, year);
		_grade = grade;
		_passed = minGrade.isBetter(grade);
	}
	public FinishedCourse (String name, Grades minGrade, Professor professor, int year, Vector<Student> students, Grades grade) {
		this(name, minGrade, professor, year, grade);
		super.setStudents(students);
	}
	
	public Grades getGrade() {
		return _grade;
	}
	public void setGrade(Grades grade) {
		_grade = grade;
	}
	public boolean isPassed() {
		return _passed;
	}
	public void setPassed(boolean passed) {
		_passed = passed;
	}
	/*Methods*/
	public String toString(){
		String returnString = "Finished" + super.halfToString() + "Grade: " + _grade + "\n";
		if(_passed)
			return returnString + "Passed}";
		else
			return returnString + "Faild}";
	}
    
}
