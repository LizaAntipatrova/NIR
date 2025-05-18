package com.strongkittens.nirstorage.data.entity.repository;

import com.strongkittens.nirstorage.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);
}
