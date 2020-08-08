package se.lexicon.course_manager_assignment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Autowired
    private Student stud1,stud2;

    @BeforeEach
    void beforeEach() {
        stud1 = new Student(11, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");
        stud2 = new Student(22,"Ilyas Mark", "ilyas2@yahoo.com", "allgatan");

    }

    @Test
    void studentTest() {
        Student studentTest = stud1;
        assertFalse(stud1 == null);
        assertEquals(11, stud1.getId());
        assertEquals("Anna Anderson", stud1.getName());
        assertEquals("anna1980@yahoo.com", stud1.getEmail());
        assertEquals("Sungatan 12", stud1.getAddress());
        assertTrue(studentTest.equals(stud1));
    }

    @Test
    void equalsTest() {
        assertFalse(stud1.equals(stud2));
        //assertFalse(stud1.equals(stud2) && stud2.equals(stud1));
    }

    @Test
    void equalNullTest() {
        assertFalse(stud1.equals(null));
    }

    @Test
    void hashCodesTest() {
        assertNotEquals(stud1,stud2);

        assertTrue(stud1.hashCode() != stud2.hashCode());
    }

    @Test
    void toStringToStudentTest() {
        //Act
        String s = stud1.toString();
        //Assert
        assertEquals(stud1.toString(),s);
    }
}
