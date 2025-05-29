package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.data.entity.User;
import com.strongkittens.nirstorage.data.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentByUserId(Long id) {
        return studentRepository.findStudentByUser_Id(id);
    }
    public Student createEmptyStudent(User user){
        Student student = new Student();
        student.setFirstName(null);
        student.setLastName(null);
        student.setMiddleName(null);
        student.setPhone(null);
        student.setGroupName(null);
        student.setUser(user);
        student.setProjects(new ArrayList<>());
        return save(student);
    }


}
