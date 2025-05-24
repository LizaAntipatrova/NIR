package com.strongkittens.nirstorage.service.converter;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.ProjectDTO;

public class ProjectToProjectDTOConverter {
    public static ProjectDTO convertProjectToProjectDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setFile(project.getFile());
        projectDTO.setGrade(project.getGrade());
        projectDTO.setTeacherName(project.getTeacher().getFirstName() + " " +
                project.getTeacher().getLastName() + " " + project.getTeacher().getMiddleName());
        projectDTO.setKeyWords(project.getKeyWords());
        projectDTO.setPublicationDate(project.getPublicationDate());
        return  projectDTO;
    }
}
