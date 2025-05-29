package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProfileStudentService;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.service.ProjectManagementService;
import com.strongkittens.nirstorage.service.ProjectService;
import com.strongkittens.nirstorage.service.converter.ProjectToProjectDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MainUIStudentService {

    private final ProjectCatalogService projectCatalogService;
    private final ProfileStudentService profileStudentService;
    private final AuthService authService;
    private final ProjectService projectService;
    private final ProjectManagementService projectManagementService;

    public String getMainStudentForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();

        if (!model.containsAttribute("projectsList")) {
            model.addAttribute("projectsList", projectDTOs);
        }
        if (!model.containsAttribute("search")) {
            model.addAttribute("search", new String());
        }

        return "student_projects_catalog";
    }

    public String getProjectsBySearch(String filter, RedirectAttributes redirectAttributes, Model model) {
        Set<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);

        redirectAttributes.addFlashAttribute("projectsList", projectDTOs);
        redirectAttributes.addFlashAttribute("search", filter);
        return "redirect:/student/main";
    }


    public String getProjectForm(Long id, Model model) {
        ProjectDTO projectDTO = projectManagementService.getProjectById(id);
        model.addAttribute("projectDTO", projectDTO);
        return "student_project_look";
    }
}
