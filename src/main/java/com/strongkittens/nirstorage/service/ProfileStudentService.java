package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.service.converter.ProjectToProjectDTOConverter;
import com.strongkittens.nirstorage.service.converter.StudentToStudentDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileStudentService {

    private final StudentService studentService;
    private final ProjectService projectService;

    public StudentDTO getStudentByUserId(Long id) {
        Student foundStudent = studentService.findStudentByUserId(id);
        return StudentToStudentDTOConverter.convertProjectToProjectDTO(foundStudent);
    }

    public void updateStudentProfileData(StudentDTO studentDTO) {
        Student student = studentService.findStudentByUserId(studentDTO.getId());

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
            student.setGroupName(studentDTO.getGroup());
        }

        studentService.save(student);
    }

    public List<ProjectDTO> getStudentsProjects(Long id) {
        Student foundStudent = studentService.findStudentByUserId(id);
        return foundStudent.getProjects().stream()
                .map(ProjectToProjectDTOConverter::convertProjectToProjectDTO)
                .toList();
    }

}
