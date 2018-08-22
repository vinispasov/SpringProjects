package com.telerikacademy.springrestdemo.controllers;

import com.telerikacademy.springrestdemo.pojo_classes.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student>students=new ArrayList<>();

    //constructor
    public StudentController() {
        students.add(new Student(1, "Ivan", "Ivanov"));
        students.add(new Student(2, "Petar", "Petrov"));
    }

    //get all students
    @GetMapping
    public List<Student> getStudents(){
        return students;
    }

    //get one student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return students.stream()
                .filter(x -> x.getId()==id)
                .findFirst()
                .orElse(null);
    }

    //create new Student
    @PostMapping("/new")
    public void createStudent(@RequestBody Student student){
        students.add(student);
    }

    //delete student
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id){
       Student student= students.stream()
                .filter(x -> x.getId()==id)
                .findFirst()
                .orElse(null);
       if (students.contains(student)){
           students.remove(student);
       }
    }

    //update Student
    @PutMapping("/{id}")
    public void updateLastName(@PathVariable int id,@RequestBody Student student){
       Student student1= students.stream()
                .filter(x -> x.getId()==id)
                .findFirst()
                .orElse(null);

        if (student1!=null){
            students.remove(student1);
            students.add(student);
        }
    }




}
