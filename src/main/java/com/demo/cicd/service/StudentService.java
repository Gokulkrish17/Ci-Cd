package com.demo.cicd.service;

import com.demo.cicd.model.Student;
import com.demo.cicd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Registered successfully";
    }

    public Student getStudent(int id){

        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
