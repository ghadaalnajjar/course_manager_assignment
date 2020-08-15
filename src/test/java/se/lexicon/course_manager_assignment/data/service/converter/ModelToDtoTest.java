package se.lexicon.course_manager_assignment.data.service.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.service.course.CourseService;
import se.lexicon.course_manager_assignment.dto.forms.CreateCourseForm;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ModelToDto.class})
public class ModelToDtoTest {

    @Autowired
    private Converters testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
    }

    //write your tests here
    @Test
    public void studentToStudentView_Test() {
        Student createStudent = new Student(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        StudentView createStudentView = testObject.studentToStudentView(createStudent);

        assertEquals(createStudent.getId(), createStudentView.getId());
    }

    @Test
    public void courseToCourseView_Test() {
        Course createCourse = new Course(1,"Java", LocalDate.parse("2020-07-13"), 20);

        CourseView createCourseView = testObject.courseToCourseView(createCourse);

        assertEquals(createCourse.getId(), createCourseView.getId());
    }

    @Test
    public void list_coursesToCourseViews_Test() {
        Course createCourse= new Course(1,"Java", LocalDate.parse("2020-07-13"), 20);

        List<Course> createCourses = new ArrayList<>();
        createCourses.add(createCourse);

        List<CourseView> createCourseView = testObject.coursesToCourseViews(createCourses);

        assertEquals(createCourses.size(), createCourseView.size());
    }

    @Test
    public void list_studentsToStudentViews_Test() {
        Student createStudent = new Student(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        List<Student>  createStudents = new ArrayList<>();
        createStudents.add(createStudent);

        List<StudentView> createStudentView = testObject.studentsToStudentViews(createStudents);

        assertEquals(createStudents.size(), createStudentView.size());
    }
}
