package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.service.converter.StudentToStudentDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileStudentService {

    private final StudentService studentService;

    public StudentDTO getStudentDTO(Long id){
        Student foundStudent = studentService.findStudentById(id);
        return StudentToStudentDTOConverter.convertProjectToProjectDTO(foundStudent);
    }

    public void updateStudentProfileData(StudentDTO studentDTO){
        Student student = studentService.findStudentById(studentDTO.getId());

        if (studentDTO.getLastName() != null) {
            student.setLastName(studentDTO.getLastName());
        }
        if (studentDTO.getFirstName() != null) {
            student.setFirstName(studentDTO.getFirstName());
        }
        if (studentDTO.getMiddleName() != null) {
            student.setMiddleName(studentDTO.getMiddleName());
        }
        if (studentDTO.getPhone() != null) {
            student.setPhone(studentDTO.getPhone());
        }
        if (studentDTO.getGroup() != null) {
            student.setGroup(studentDTO.getGroup());
        }

        studentService.save(student);
    }
}
