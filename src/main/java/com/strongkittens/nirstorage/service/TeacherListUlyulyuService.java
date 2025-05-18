package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherListUlyulyuService {

    private final TeacherRepository teacherRepository;

    public List<String> getAllTeachersFullNamesUUUU() {
        return teacherRepository.findAll().stream()
                .map(teacher -> String.join(" ",
                        teacher.getLastName(),
                        teacher.getFirstName(),
                        teacher.getMiddleName()
                ).trim())
                .collect(Collectors.toList());
    }


}
