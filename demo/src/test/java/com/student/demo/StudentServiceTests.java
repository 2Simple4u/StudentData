package com.student.demo;

import com.student.demo.dto.StudentRequest;
import com.student.demo.dto.StudentResponse;
import com.student.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class StudentServiceTests {

    public void addStudent(StudentRequest request){};
    public void getAllStudents(){};
    public void deleteAllStudent(){};
    public void updateStudentByName(Student request, Long id){};
}
