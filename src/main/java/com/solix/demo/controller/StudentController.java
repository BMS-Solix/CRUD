package com.solix.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solix.demo.entity.StudentEntity;
import com.solix.demo.repository.StudentRepository;

@RestController("/api")
public class StudentController {
    @Autowired
	StudentRepository repo;
    
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents(){
    	List<StudentEntity> students =repo.findAll();
    	return students;
    }
    
    @GetMapping("/students/{id}")
    public StudentEntity getStudent(@PathVariable int id) {
    	StudentEntity student = repo.findById(id).get();
    	return student;
    }
    
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createStudent(@RequestBody StudentEntity student) {
    	repo.save(student);
    	return ResponseEntity.ok("Student Added");
    }
    
    @PutMapping("/student/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<String> updateStudent(@RequestBody StudentEntity student) {
    	repo.save(student);
    	return ResponseEntity.ok("Studnet updated");
    }
    
    
    @DeleteMapping("student/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> removeStudent(@PathVariable int id) {
         StudentEntity student = repo.findById(id).get();
    	repo.delete(student);	
    	return ResponseEntity.ok("Student Removed");
    }
}
