package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainUIStudentService {

    private final ProjectCatalogService projectCatalogService;

    public String getMainStudentForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();
        model.addAttribute("projectsList", projectDTOs);
        model.addAttribute("search", new String());

        return "student_project_catalog";
    }

    public String getProjectsBySearch(String filter, Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);
        return "redirect:/student/main";
    }

}
