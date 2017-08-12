package entityTests;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import entities.Course;
import entities.Grades;
import entities.Professor;
import entities.Student;
import entities.FinishedCourse;

public class FinishedCourseTest {
    FinishedCourse flying;
    
        @Test
        public void toStringTest() 
        {
            flying = new FinishedCourse("flying", Grades.O, new Professor("Madame Hooch"), 1996, Grades.A);
            
            String actual = flying.toString();
            String expected = "FinishedCourse{\nName: flying\nMinGrade: O\nProfessor: Madame Hooch\nYear: 1996\nGrade: A\nFailed}";
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void setGradeTest() 
        {
            flying = new FinishedCourse("flying", Grades.O, new Professor("Madame Hooch"), 1996, Grades.A);
            flying.setGrade(Grades.E);
            Grades expected = Grades.E;
            Grades actual = flying.getGrade();
            
            Assert.assertEquals(expected, actual);
        }
        @Test
        public void isPassedTest() {
            flying = new FinishedCourse("flying", Grades.O, new Professor("Madame Hooch"), 1996, Grades.A);
            boolean expected = false;
            boolean actual = flying.isPassed();
            
            Assert.assertEquals(expected, actual);
        }
    }
