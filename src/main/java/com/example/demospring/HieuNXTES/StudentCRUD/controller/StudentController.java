package com.example.demospring.HieuNXTES.StudentCRUD.controller;

import com.example.demospring.HieuNXTES.StudentCRUD.entity.Student;
import com.example.demospring.HieuNXTES.StudentCRUD.service.StudentService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/")
  public Student create(@RequestBody Student request) {
    return studentService.add(request);
  }
  @PutMapping({"/{stdId}"})
  public ResponseEntity<Student> update(@RequestBody Student request, @PathVariable("stdId") Long stdId) {
    studentService.updateStudent(stdId, request);
    return new ResponseEntity<>(studentService.getStudentById(stdId), HttpStatus.OK);
  }
  @GetMapping
  public ResponseEntity<List<Student>> getAllStd() {
    List<Student> stds = studentService.getListStd();
    return new ResponseEntity<>(stds, HttpStatus.OK);
  }
  @GetMapping({"/{stdId}"})
  public ResponseEntity<Student> getStd(@PathVariable Long stdId) {
    return new ResponseEntity<>(studentService.getStudentById(stdId), HttpStatus.OK);
  }
  @DeleteMapping({"/{stdId}"})
  public ResponseEntity<Student> deleteStd(@PathVariable("stdId") Long stdId) {
    studentService.deleteStudent(stdId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}