package se.lexicon.course_manager_assignment.data.service.course;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.data.service.converter.ModelToDto;
import se.lexicon.course_manager_assignment.data.service.student.StudentService;
import se.lexicon.course_manager_assignment.dto.forms.CreateCourseForm;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CourseManager.class, CourseCollectionRepository.class, ModelToDto.class, StudentCollectionRepository.class})
public class CourseManagerTest {

    @Autowired
    private CourseService testObject;

    @Autowired
    private CourseDao courseDao;


    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
        assertNotNull(courseDao);
    }

    //Write your tests here
    @Test
    public void createCourseView_toUpdate_Test() {
        CreateCourseForm createCourse = new CreateCourseForm(1,"Java", LocalDate.parse("2020-07-13"), 20);

        CourseView createCourseView = testObject.create(createCourse);
        CourseView findCourseById = testObject.findById(1);
        assertEquals(createCourseView, findCourseById);

        //UpdateCourseForm
        UpdateCourseForm updateCourseForm = new UpdateCourseForm(1,"Oracel", LocalDate.parse("2020-07-13"), 30);
        CourseView updateCourse = testObject.update(updateCourseForm);
        CourseView findByIdUpdateCourse = testObject.findById(1);
        assertEquals(updateCourse, findByIdUpdateCourse);
    }

    @Test
    public void searchByNameTest() {
        List<Course> courseListView = new ArrayList<>(courseDao.findByNameContains("Java"));

        List<CourseView> searchByNameCourse = new ArrayList<>(testObject.searchByCourseName("Java")) ;

        assertEquals(courseListView, searchByNameCourse);
    }

    @Test
    public void searchByBeforeDateTest() {
        List<Course> courseListView = new ArrayList<>(courseDao.findByDateBefore(LocalDate.parse("2020-07-13")));

        List<CourseView> searchByNameCourse = new ArrayList<>(testObject.searchByDateBefore(LocalDate.parse("2020-07-13"))) ;

        assertEquals(courseListView, searchByNameCourse);
    }

    @Test
    public void searchByAfterDateTest() {
        List<Course> courseListView = new ArrayList<>(courseDao.findByDateAfter(LocalDate.parse("2020-07-13")));

        List<CourseView> searchByNameCourse = new ArrayList<>(testObject.searchByDateAfter(LocalDate.parse("2020-07-13")));

        assertEquals(courseListView, searchByNameCourse);
    }


    @Test
    public void findAll_ListCourseViewTest() {
        List<Course> courseListView = new ArrayList<>(courseDao.findAll());

        List<CourseView> findAllList = new ArrayList<>(testObject.findAll()) ;

        assertEquals(courseListView, findAllList);
    }

    @Test
    public void deleteCourseViewTest() {
        CreateCourseForm createCourse = new CreateCourseForm(1,"Java", LocalDate.parse("2020-07-13"), 20);

        testObject.create(createCourse);

        assertTrue(courseDao.removeCourse(courseDao.findById(1)));

    }

    @AfterEach
    void tearDown() {
        courseDao.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
