package com.student.demo.service;

import com.student.demo.dto.StudentRequest;
import com.student.demo.dto.StudentResponse;
import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements studentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public ResponseEntity<StudentResponse> addStudent(StudentRequest request) {
        var StudentData = Student.builder()
                .age(request.getAge())
                .name(request.getName())
                .salary(request.getSalary())
                .build();
        this.studentRepository.save(StudentData);
        return new ResponseEntity("Student is added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<Student> studentResponse = studentRepository.findAll();
        return new ResponseEntity(studentResponse,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllStudent() {
        this.studentRepository.deleteAll();
        return  new ResponseEntity("All Delete student",HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Student> updateStudentByName(Student request, Long id) {
        var UpdateStudent = studentRepository.findById(id).orElseThrow();
        UpdateStudent.setName(request.getName());
        UpdateStudent.setSalary(request.getSalary());
        UpdateStudent.setAge(request.getAge());
        studentRepository.save(UpdateStudent);
        return new ResponseEntity<>(UpdateStudent, HttpStatus.OK);

    }
}
