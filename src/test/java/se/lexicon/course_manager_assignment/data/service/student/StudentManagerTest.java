package se.lexicon.course_manager_assignment.data.service.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.data.service.converter.ModelToDto;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {StudentManager.class, CourseCollectionRepository.class, StudentCollectionRepository.class, ModelToDto.class})
public class StudentManagerTest {

    @Autowired
    private StudentService testObject;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentManager studentManager;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
        assertNotNull(studentDao);
    }

    //Write your tests here

    @Test
    public void createStudentView_toUpdate_Test() {
        CreateStudentForm createStudent = new CreateStudentForm(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        StudentView createStudentView = testObject.create(createStudent);
        StudentView findStudentById = testObject.findById(1);
        assertEquals(createStudentView,findStudentById);

        //UpdateStudentForm
        UpdateStudentForm updateStudentForm  = new UpdateStudentForm(1, "Ali Anderson", "aa190@yahoo.com", "Allgatan 12");
        StudentView updateStudent = testObject.update(updateStudentForm);
        StudentView findByIdUpdateStudent = testObject.findById(1);
        assertEquals(updateStudent, findByIdUpdateStudent);
    }

    @Test
    public void searchByEmailTest() {
        CreateStudentForm createStudent = new CreateStudentForm(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        StudentView createStudentView = testObject.create(createStudent);

        StudentView searchByEmailStudent = testObject.searchByEmail("anna1980@yahoo.com");

        assertEquals(createStudentView, searchByEmailStudent);
    }

    @Test
    public void searchByNameTest() {
        List<Student> studentListView = new ArrayList<>(studentDao.findByNameContains("Anna Anderson"));

       List<StudentView> searchByNameStudent = new ArrayList<>(testObject.searchByName("Anna Anderson")) ;

       assertEquals(studentListView, searchByNameStudent);

    }

    @Test
    public void findAll_ListStudentViewTest() {
        List<Student> studentListView = new ArrayList<>(studentDao.findAll());

        List<StudentView> findAllList = new ArrayList<>(testObject.findAll()) ;

        assertEquals(studentListView, findAllList);
    }

    @Test
    public void deleteStudentViewTest() {
        CreateStudentForm createStudent = new CreateStudentForm(1, "Anna Anderson", "anna1980@yahoo.com", "Sungatan 12");

        testObject.create(createStudent);

        assertTrue(studentDao.removeStudent(studentDao.findById(1)));

    }
    @AfterEach
    void tearDown() {
        StudentSequencer.setStudentSequencer(0);
        studentDao.clear();
    }
}
