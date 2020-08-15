package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.*;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students = null;

    //The constructor method
    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public Course() {
    }

    public Course(int nextCourseId, String courseName, LocalDate startDate, int weekDuration) {
        this.id = nextCourseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        if (student == null || students.contains(student)) {
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean unenrollStudent(Student student) {
        if (student == null || !students.contains((student))) {
            return false;
        }
        students.remove(student);
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Course course = (Course) object;
        return id == course.id && weekDuration == course.weekDuration && courseName.equals(course.courseName) && startDate.equals(course.startDate) && students.equals(course.students) && students.equals(course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students, students);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName='" + courseName + '\'' + ", startDate=" + startDate + ", weekDuration=" + weekDuration + ", students=" + students + ", studentList=" + students + '}';
    }
}
