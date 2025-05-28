package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.converter.ProjectToProjectDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectCatalogService {
    private final ProjectService projectService;

    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects().stream()
                .map(ProjectToProjectDTOConverter::convertProjectToProjectDTO)
                .collect(Collectors.toList());
    }

    public Set<ProjectDTO> findProjectsBySubstring(String substring) {
        substring = substring.toLowerCase();
        Set<ProjectDTO> projectDTOS = new HashSet<>();
        projectDTOS.addAll(projectService.getProjectsBySubstringInName(substring).stream()
                .map(ProjectToProjectDTOConverter::convertProjectToProjectDTO)
                .collect(Collectors.toSet()));
        projectDTOS.addAll(projectService.getProjectsBySubstringInKeyWords(substring).stream()
                .map(ProjectToProjectDTOConverter::convertProjectToProjectDTO)
                .collect(Collectors.toSet()));
        return projectDTOS;
    }

    public List<ProjectDTO> getTeachersProjectByTeacherUserId(Long teacherId) {
        return projectService.getProjectsByTeacherUserId(teacherId).stream()
                .map(ProjectToProjectDTOConverter::convertProjectToProjectDTO)
                .toList();
    }


}
