package com.strongkittens.nirstorage.service.converter;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.dto.StudentDTO;

public class StudentToStudentDTOConverter {
    public static StudentDTO convertProjectToProjectDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setMiddleName(student.getMiddleName());
        studentDTO.setPhone(student.getPhone());
        studentDTO.setGroup(student.getGroupName());
        studentDTO.setEmail(student.getUser().getLogin());
        return studentDTO;
    }
}
