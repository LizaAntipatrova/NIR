package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectCatalogService {
    private final ProjectService projectService;
    public List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects().stream()
                .map(this::convertProjectToProjectDTO)
                .collect(Collectors.toList());
    }
    public List<ProjectDTO> findProjectsBySubstring(String substring){
        substring = substring.toLowerCase();
        List<ProjectDTO> projectDTOS= new ArrayList<>();
        projectDTOS.addAll(projectService.getProjectsBySubstringInName(substring).stream()
                .map(this::convertProjectToProjectDTO)
                .toList());
        projectDTOS.addAll(projectService.getProjectsBySubstringInKeyWords(substring).stream()
                .map(this::convertProjectToProjectDTO)
                .toList());
        return projectDTOS;
    }
    public List<ProjectDTO> getTeachersProject(Long teacherId){
        return projectService.getProjectsByTeacherId(teacherId).stream()
                .map(this::convertProjectToProjectDTO)
                .toList();
    }

    private ProjectDTO convertProjectToProjectDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setFile(project.getFile());
        projectDTO.setGrade(project.getGrade());
        projectDTO.setTeacherName(project.getTeacher().getFirstName());
        projectDTO.setKeyWords(project.getKeyWords());
        projectDTO.setPublicationDate(project.getPublicationDate());
        return  projectDTO;
    }

}
