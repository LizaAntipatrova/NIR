package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
