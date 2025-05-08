package com.demo.cicd.controller;

import com.demo.cicd.dto.StringResponse;
import com.demo.cicd.model.Student;
import com.demo.cicd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StringResponse> registerStudents(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StringResponse(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getRegisteredStudent(@PathVariable int id){
        Student student = studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/message")
    public String getMessage(){
        return "Welcome to ci-cd course";
    }

    @GetMapping("/get-all-registers")
    public ResponseEntity<List<Student>> getAllRegisteredStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
