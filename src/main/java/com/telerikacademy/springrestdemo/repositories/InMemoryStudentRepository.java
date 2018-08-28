package com.telerikacademy.springrestdemo.repositories;

import com.telerikacademy.springrestdemo.pojo_classes.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryStudentRepository implements StudentRepository {
    //fields
    private List <Student> students=new ArrayList<>();

    //constructor
    public InMemoryStudentRepository() {
        students.add(new Student(1, "Ivan", "Ivanov"));
        students.add(new Student(2, "Petar", "Petrov"));
    }

    //methods
    @Override
    public void createStudent(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        return getStudent(id);
    }

    private Student getStudent(int id) {
        return students.stream()
                .filter(s ->s.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateStudent(int id, Student student) {
        Student s=getStudent(id);
        int index=students.indexOf(s);
        students.set(index,student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student=getStudent(id);
        students.remove(student);
    }
}
