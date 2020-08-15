package se.lexicon.course_manager_assignment.model;

import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;

import java.util.Objects;

public class Student {

    //field
    private int id;
    private String name;
    private String email;
    private String address;

    //The constructor method
    public Student(int id,String name, String email, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Student() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Student student = (Student) object;
        return id == student.id && name.equals(student.name) && email.equals(student.email) && address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + '}';
    }
}





