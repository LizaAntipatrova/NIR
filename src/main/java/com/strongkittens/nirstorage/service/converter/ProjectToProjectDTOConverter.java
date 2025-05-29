package com.strongkittens.nirstorage.service.converter;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.fileororo.ByteMultipartFile;

public class ProjectToProjectDTOConverter {
    public static ProjectDTO convertProjectToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setFile(
                new ByteMultipartFile(
                        project.getFile(),
                        project.getName(),
                        project.getName(),
                        "application/pdf"));

        projectDTO.setGrade(project.getGrade());
        projectDTO.setTeacherId(project.getTeacher().getUser().getId());

        projectDTO.setTeacherName(getFullName(project.getTeacher().getFirstName(),
                project.getTeacher().getLastName(), project.getTeacher().getMiddleName()));

        projectDTO.setAuthorsNames(project.getStudents().stream()
                .map((x) -> getFullName(x.getFirstName(), x.getLastName(), x.getMiddleName()))
                .toList());

        projectDTO.setKeyWords(project.getKeyWords());
        projectDTO.setPublicationDate(project.getPublicationDate());
        return projectDTO;
    }

    private static String getFullName(String firstName, String lastName, String middleName) {
        return firstName + " " + lastName + " " + middleName;
    }
}
