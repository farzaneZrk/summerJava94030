package entityTests;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import entities.Course;
import entities.Grades;
import entities.Professor;
import entities.Student;

public class CourseTest {
    Course flying;
    
        @Test
        public void toStringTest() 
        {
            flying = new Course("flying", new Professor("Madame Hooch"), Grades.O, 1996);
            Vector<Student> students = new Vector<Student>();
            students.add(new Student("Harry Potter"));
            students.add(new Student("Ron Weasley"));
            students.add(new Student("Hermoine Granger"));
            students.add(new Student("Draco Malfoy"));
            flying.setStudents(students);
            
            String actual = flying.toString();
            String expected = "Course{\nName: flying\nMinGrade: O\nProfessor: Madame Hooch\nYear: 1996\n";
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void studentsTest() 
        {
            flying = new Course("Flying");
            Vector<Student> students = new Vector<Student>();
            students.add(new Student("Harry Potter"));
            students.add(new Student("Ron Weasley"));
            students.add(new Student("Hermoine Granger"));
            students.add(new Student("Draco Malfoy"));
            flying.setStudents(students);
            
            Vector<Student> actual = flying.getStudents();
            Vector<Student> expected = students;
            
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        }
        @Test
        public void getProfessorTest() {
            flying = new Course("flying", new Professor("Madame Hooch"), Grades.O, 1996);
            Professor expected = new Professor ("Madame Hooch");
            Professor actual = flying.getProfessor();
            
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void getNameTest() {
            flying = new Course("flying", new Professor("Madame Hooch"), Grades.O, 1996);
            String expected = "flying";
            String actual = flying.getName();
            
            Assert.assertEquals(expected, actual);
            
        }
        @Test
        public void getMinGradeTest() {
            flying = new Course("flying", new Professor("Madame Hooch"), Grades.O, 1996);
            Grades expected = Grades.O;
            Grades actual = flying.getMinGrade();
            
            Assert.assertEquals(expected, actual);
    
        }
        @Test
        public void setProfessorTest() {
            flying = new Course("Flying");
            flying.setProfessor(new Professor("Madame Hooch"));
            Professor expected = new Professor("Madame Hooch");
            Professor actual = flying.getProfessor();
            
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void setNameTest() {
            flying = new Course("");
            flying.setName("Flying");
            String expected = "Flying";
            String actual = flying.getName();
            
            Assert.assertEquals(expected, actual);
            
        }
        
    
}
