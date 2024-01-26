package com.crud.controller;

import com.crud.model.Student;
import com.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // post call
    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK).body("Data Saved Successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getStudent(){
        Optional<List<Student>> studentList = Optional.of(studentRepository.findAll());
        if(!studentList.get().isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(studentList.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }

    }
}
