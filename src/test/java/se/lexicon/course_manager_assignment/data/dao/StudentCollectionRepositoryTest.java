package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here

    @Test
    public void given_student_findByEmailIgnoreCase_returnStudent_Test() {
        Student student = testObject.createStudent("Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        // Test create student method
        List<Student> studentList = new ArrayList<>(testObject.findAll());
        assertEquals(1, studentList.size());

        Student findByIdStudent = testObject.findByEmailIgnoreCase("anna1980@yahoo.com");

        assertEquals(findByIdStudent, student);
    }

    @Test
    public void given_student_findById_returnStudent_Test() {
        Student student = testObject.createStudent("Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        Student findByIdStudent = testObject.findById(student.getId());

        assertEquals(findByIdStudent, student);
    }

    @Test
    public void given_student_findByNameContains_Test(){
        testObject.createStudent("Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        Collection<Student> findByNameStudent = testObject.findByNameContains("Anna Anderson");

        assertEquals(findByNameStudent.size(), 1);
    }

    @Test
    public void removeStudent_Test() {
        Student student = testObject.createStudent("Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        assertTrue(testObject.removeStudent(testObject.findById(student.getId())));
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }
}
