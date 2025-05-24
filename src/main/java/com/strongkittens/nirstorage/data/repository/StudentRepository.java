package com.strongkittens.nirstorage.data.repository;

import com.strongkittens.nirstorage.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByUser_Id(Long id);
}
