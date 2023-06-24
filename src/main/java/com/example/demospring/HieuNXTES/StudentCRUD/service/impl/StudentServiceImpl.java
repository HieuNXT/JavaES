package com.example.demospring.HieuNXTES.StudentCRUD.service.impl;

import com.example.demospring.HieuNXTES.StudentCRUD.entity.Student;
import com.example.demospring.HieuNXTES.StudentCRUD.repository.StudentRepository;
import com.example.demospring.HieuNXTES.StudentCRUD.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentRepository studentRepository;
  @Override
  public Student add(Student request) {
    studentRepository.save(request);
    return request;
  }
   @Override
   public List<Student> getListStd() {
     List<Student> students = new ArrayList<>();
     studentRepository.findAll().forEach(students::add);
     return students;
   }
  @Override
  public Student getStudentById(Long id) {
    return studentRepository.findById(id).get();
  }
  @Override
  public ResponseEntity<Student> updateStudent(Long id, Student student) {
    Student studentFromDb = studentRepository.findById(id).get();
    System.out.println(studentFromDb.toString());
    studentFromDb.setStdName(student.getStdName());
    studentFromDb.setStdEmail(student.getStdEmail());
    studentFromDb.setStdPhone(student.getStdPhone());
    studentFromDb.setStdAddress(student.getStdAddress());
    studentRepository.save(studentFromDb);
    return null;
  }
  @Override
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }
}
