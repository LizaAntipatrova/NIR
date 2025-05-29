package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.service.ProjectManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MainUITeacherService {
    private final ProjectCatalogService projectCatalogService;
    private final ProjectManagementService projectManagementService;
    private final AuthService authService;


    public String getMainTeacherForm(Model model) {
        List<ProjectDTO> projectDTOs = projectCatalogService.getAllProjects();
        model.addAttribute("projectsList", projectDTOs);
        model.addAttribute("search", new String());

        return "teacher_project_catalog";
    }

    public String getProjectsBySearch(String filter, Model model) {
        Set<ProjectDTO> projectDTOs = projectCatalogService.findProjectsBySubstring(filter);
        return "redirect:/teacher/main";
    }

    public String getProjectForm(Long nirId, Model model, String cookie) {
        ProjectDTO projectDTO = projectManagementService.getProjectById(nirId);
        model.addAttribute("projectDTO", projectDTO);
        Long databaseTeacherId = authService.getUserIdFromCookie(cookie);
        if(projectDTO.getGrade() == null && projectDTO.getTeacherId().equals(databaseTeacherId)){
            return "teacher_project_look";
        }
        return "teacher_project_look_without_grade.html";

    }

    public String postGiveGrade(Long id, Integer grade) {
        projectManagementService.giveGrade(grade, id);
        return "redirect:/teacher/nir?id="+ id;
    }
}
