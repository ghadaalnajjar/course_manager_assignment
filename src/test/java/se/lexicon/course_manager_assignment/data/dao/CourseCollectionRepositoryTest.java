package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;


    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here

    @Test
    public void given_course_findById_returnCourse_Test() {
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 22);

        Course findCourse = testObject.findById(course.getId());

        assertEquals(findCourse,course);
    }

    @Test
    public void given_student_findByNameContains_Test(){
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 22);

        Collection<Course> courses = new ArrayList<>(testObject.findByNameContains("Java"));

        assertEquals(1,courses.size());
    }

    @Test
    public void findByDateBefore_Test() {
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 1);

        Collection<Course> courses = new ArrayList<>(testObject.findByDateBefore(LocalDate.parse("2020-06-25")));

        assertEquals(courses.size() ,1);
    }

    @Test
    public void findByDateAfter_Test() {
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 22);

        Collection<Course> courses = new ArrayList<>(testObject.findByDateAfter(LocalDate.parse("2020-06-17")));

        assertEquals(courses.size() ,1);
    }

    @Test
    public void findAllCourse_Test() {
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 1);

        Collection<Course> courses = new ArrayList<>(testObject.findAll());

        assertEquals(courses.size() ,1);
    }

    @Test
    public void findByStudentId_Test() {
        Collection<Course> courses = new ArrayList<>(testObject.findByStudentId(1));

        assertEquals(0, courses.size());
    }

    @Test
    public void removeCourse_Test() {
        Course course = testObject.createCourse("Java", LocalDate.parse("2020-06-18"), 22);

        assertTrue(testObject.removeCourse(course));

    }

        @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
