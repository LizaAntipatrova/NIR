package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.CreateProjectDTO;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.ProjectManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class LoadProjectUIStudentService {
    private final ProjectManagementService projectManagementService;
    private final AuthService authService;

    public String getStudentLoadProjectForm(Model model) {
        model.addAttribute("createProjectDTO", new CreateProjectDTO());
        return "student_project_load";
    }
    public String postStudentLoadProject(CreateProjectDTO createProjectDTO, String cookie) {
        createProjectDTO.getAuthorsId().add(authService.getUserIdFromCookie(cookie));
        projectManagementService.createProject(createProjectDTO);
        return "redirect:/student/main";
    }
}
