package se.lexicon.course_manager_assignment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Autowired
    private Course course;

    @Autowired
    private Course courseTest;

    @Autowired
    private Student student;

    @BeforeEach
    void before(){

        course =new Course(10, "Java", LocalDate.parse("2020-06-18"), 22, Arrays.asList(student));
        courseTest =new Course(20, "C++", LocalDate.parse("2020-07-20"), 18, Arrays.asList(student));
    }

    @Test
    void enrollstudentTest() {
        //Assert
        assertFalse(course.enrollStudent(student));
    }

    @Test
    void enrollStudentEqualsTest() {
        //assert
        assertTrue(course.equals(course));
    }

    @Test
    void unenrollStudentTest() {
        //Act
        Student studentTest = new Student(22,"Ilyas Mark", "ilyas2@yahoo.com", "allgatan");

        //assert
        assertFalse(course.unenrollStudent(studentTest));
    }

    @Test
    void equalNullTest() {
        assertFalse(course.equals(null));
    }

    @Test
    void hashCodesTest() {
        assertNotEquals(course,courseTest);

        assertTrue(course.hashCode() != courseTest.hashCode());
    }

    @Test
    void toStringToStudentTest() {
        //Act
        String toString = course.toString();
        //Assert
        assertEquals(course.toString(),toString);
    }

}
