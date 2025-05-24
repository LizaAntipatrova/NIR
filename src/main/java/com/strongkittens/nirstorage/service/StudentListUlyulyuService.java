package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentListUlyulyuService {
    private final StudentRepository studentRepository;

    public List<String> getAllStudentFullNamesUUUU() {
        return studentRepository.findAll().stream()
                .map(student -> String.join(" ",
                        student.getLastName(),
                        student.getFirstName(),
                        student.getMiddleName()
                ).trim())
                .collect(Collectors.toList());
    }
}
