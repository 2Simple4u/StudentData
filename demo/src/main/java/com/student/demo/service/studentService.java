package com.student.demo.service;

import com.student.demo.dto.StudentRequest;
import com.student.demo.dto.StudentResponse;
import com.student.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface studentService{

    public ResponseEntity<StudentResponse> addStudent(StudentRequest request);
    public ResponseEntity<List<StudentResponse>> getAllStudents();
    public ResponseEntity<HttpStatus> deleteAllStudent();
    public ResponseEntity<Student> updateStudentByName(Student request, Long id);
}
