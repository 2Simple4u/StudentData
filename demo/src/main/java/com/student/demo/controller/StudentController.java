package com.student.demo.controller;
import com.student.demo.dto.StudentRequest;
import com.student.demo.dto.StudentResponse;
import com.student.demo.model.Student;
import com.student.demo.service.StudentServiceImpl;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentServiceImpl studentService;


   Logger logger = LoggerFactory.getLogger(StudentController.class.getName());

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<StudentResponse> registerNewStudent(@RequestBody StudentRequest studentRequest){
       logger.info("Request for new student ");
        return this.studentService.addStudent(studentRequest);

    }


    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        logger.info("Request for all student ");
      return   this.studentService.getAllStudents();

    }
    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllStudent(){
        logger.info("Request for delete student ");
        return  this.studentService.deleteAllStudent();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentByName(@RequestBody Student student, @PathVariable Long id){
        logger.info("Request for update student ");
        return this.studentService.updateStudentByName(student,id);
    }

}
