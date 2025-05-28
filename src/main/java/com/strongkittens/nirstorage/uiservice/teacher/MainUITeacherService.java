package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.service.ProjectManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainUITeacherService {
    private final ProjectCatalogService projectCatalogService;
    private final ProjectManagementService projectManagementService;


    public String getMainTeacherForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();
        model.addAttribute("projectsList", projectDTOs);
        model.addAttribute("search", new String());

        return "teacher_project_catalog";
    }

    public String getProjectsBySearch(String filter, Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);
        return "redirect:/teacher/main";
    }

    public String getProjectForm(Long nirId, Model model) {
        ProjectDTO projectDTO = projectManagementService.getProjectById(nirId);
        model.addAttribute("projectDTO", projectDTO);
        return "teacher_project_look";
    }
}
