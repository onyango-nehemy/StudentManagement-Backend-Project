package com.example.studentapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController{
    @Autowired

    private StudentRepository studentRepository;

    //create student

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get all students
    @GetMapping
    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }
    //get one student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentRepository.findById(id).orElse(null);
    }

    //update Students
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent){
        return studentRepository.findById(id).map(student ->{
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            return studentRepository.save(student);
        }).orElse(null);
        
    }
    //Delete Student
    @DeleteMapping
    public void deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
    }
}