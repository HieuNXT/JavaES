package com.example.demospring.HieuNXTES.StudentCRUD.repository;

import com.example.demospring.HieuNXTES.StudentCRUD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
