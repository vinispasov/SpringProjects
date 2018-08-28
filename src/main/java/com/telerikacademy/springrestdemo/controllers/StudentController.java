package com.telerikacademy.springrestdemo.controllers;

import com.telerikacademy.springrestdemo.pojo_classes.Student;
import com.telerikacademy.springrestdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    //fields
    private StudentService service;

    //constructor
    @Autowired
    public StudentController(StudentService service){
        this.service=service;
    }

    //methods:
    //get all students
    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }

    //get one student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    //create new Student
    @PostMapping("/new")
    public void createStudent(@RequestBody Student student){
        service.createStudent(student);
    }

    //delete student
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id){
        service.deleteStudent(id);
    }

    //update Student
    @PutMapping("/{id}")
    public void updateStudent(int id,Student student){
      service.updateStudent(id,student);
    }




}
