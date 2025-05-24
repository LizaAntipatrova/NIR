package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.data.entity.User;
import com.strongkittens.nirstorage.data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher createEmptyTeacher(User user){
        Teacher teacher = new Teacher();
        teacher.setFirstName(null);
        teacher.setLastName(null);
        teacher.setMiddleName(null);
        teacher.setPhone(null);
        teacher.setJob(null);
        teacher.setUser(user);
        teacher.setProjects(new ArrayList<>());
        return save(teacher);
    }

}
