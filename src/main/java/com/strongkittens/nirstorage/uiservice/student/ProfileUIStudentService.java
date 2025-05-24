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
        setUpStudentProfileDataInModel(model, cookie);

        return "student_profile";
    }
    public String getStudentEditProfileForm(Model model, String cookie) {
        setUpStudentProfileDataInModel(model, cookie);

        return "student_profile_edit";
    }

    private void setUpStudentProfileDataInModel(Model model, String cookie) {
        Long userId = authService.getUserIdFromCookie(cookie);
        StudentDTO studentDTO = profileStudentService.getStudentByUserId(userId);
        List<ProjectDTO> projectDTOS = profileStudentService.getStudentsProjects(userId);
        model.addAttribute("projectsList", projectDTOS);
        model.addAttribute("studentDTO", studentDTO);
    }

    public String postStudentEditProfileForm(StudentDTO studentDTO) {
        profileStudentService.updateStudentProfileData(studentDTO);
        return "redirect:/student/profile";
    }
}
