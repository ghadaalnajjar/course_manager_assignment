package se.lexicon.course_manager_assignment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Autowired
    private Student stud;

    @BeforeEach
    void befor() {
        stud = new Student(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");
    }

    @Test
    void studentTest() {
        Student studentTest = stud;
        assertFalse(stud == null);
        assertEquals(1, stud.getId());
        assertEquals("Anna Anderson", stud.getName());
        assertEquals("anna1980@yahoo.com", stud.getEmail());
        assertEquals("Sungatan 12", stud.getAddress());
        assertTrue(studentTest.equals(stud));
    }

}
