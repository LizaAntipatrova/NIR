package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainUITeacherService {
    private final ProjectCatalogService projectCatalogService;


    public String getMainTeacherForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();
        model.addAttribute("projectsList", projectDTOs);

        return "teacher_project_catalog";
    }

    public String getProjectsBySearch(String filter, Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);

        model.addAttribute("projectsList", projectDTOs);
        return "teacher_project_catalog";
    }

}
