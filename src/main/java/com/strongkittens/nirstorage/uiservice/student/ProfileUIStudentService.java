package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.service.ProfileStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileUIStudentService {
    private final ProfileStudentService profileStudentService;
    private final AuthService authService;

    public String getStudentProfileForm(Model model, String cookie) {
        Long userId = authService.getUserIdFromCookie(cookie);
        StudentDTO studentDTO = profileStudentService.getStudentByUserId(userId);
        List<ProjectDTO> projectDTOS = profileStudentService.getStudentsProjects(userId);
        model.addAttribute("projectsList", projectDTOS);
        model.addAttribute("studentDTO", studentDTO);

        return "student_profile";
    }

}
