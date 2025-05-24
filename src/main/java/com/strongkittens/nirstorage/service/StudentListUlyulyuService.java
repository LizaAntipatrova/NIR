package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.repository.StudentRepository;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.service.converter.StudentToStudentDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentListUlyulyuService {
    private final StudentRepository studentRepository;

    public List<StudentDTO> getAllStudentFullNamesExceptAuthorUUUU(Long authorUserId) {
        return studentRepository.findAll().stream()
                .filter((student) -> !student.getUser().getId().equals(authorUserId))
                .map(StudentToStudentDTOConverter::convertStudentToStudentDTO)
                .collect(Collectors.toList());
    }
}
