package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
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

    public Teacher findTeacherByUserId(Long id) {
        return teacherRepository.findTeacherByUser_Id(id);
    }
    public Teacher findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
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
