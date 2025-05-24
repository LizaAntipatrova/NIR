package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.repository.StudentRepository;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.service.converter.StudentToStudentDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentListUlyulyuService {
    private final StudentRepository studentRepository;

    public List<StudentDTO> getAllStudentFullNamesUUUU() {
        return studentRepository.findAll().stream()
                .map(StudentToStudentDTOConverter::convertStudentToStudentDTO)
                .toList();
    }
}
