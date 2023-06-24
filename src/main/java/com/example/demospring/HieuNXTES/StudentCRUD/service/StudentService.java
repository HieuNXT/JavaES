package com.example.demospring.HieuNXTES.StudentCRUD.service;

import com.example.demospring.HieuNXTES.StudentCRUD.entity.Student;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface StudentService {

  Student add(Student request);

  List<Student> getListStd();

  Student getStudentById(Long id);

  ResponseEntity<Student> updateStudent(Long id, Student student);

  void deleteStudent(Long id);
}
