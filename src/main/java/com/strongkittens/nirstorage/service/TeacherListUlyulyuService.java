package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.repository.TeacherRepository;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.service.converter.TeacherToTeacherDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherListUlyulyuService {

    private final TeacherRepository teacherRepository;

    public List<TeacherDTO> getAllTeachersFullNamesUUUU() {
        return teacherRepository.findAll().stream()
                .map(TeacherToTeacherDTOConverter::convertTeacherToTeacherDTO)
                .collect(Collectors.toList());
    }


}
