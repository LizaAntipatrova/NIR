package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProfileStudentService;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainUIStudentService {

    private final ProjectCatalogService projectCatalogService;
    private final ProfileStudentService profileStudentService;
    private final AuthService authService;

    public String getMainStudentForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();
        model.addAttribute("projectsList", projectDTOs);
        model.addAttribute("search", new String());

        return "student_projects_catalog";
    }

    public String getProjectsBySearch(String filter, Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);
        return "redirect:/student/main";
    }

}
