package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.service.ProfileTeacherService;
import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.service.TeacherService;
import com.strongkittens.nirstorage.service.converter.TeacherToTeacherDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileUITeacherService {
    private final ProfileTeacherService profileTeacherService;
    private final ProjectCatalogService projectCatalogService;
    private final AuthService authService;
    private final TeacherService teacherService;

    public String getProfileMainPage(Model model, String cookie){
        Long userId = authService.getUserIdFromCookie(cookie);
        TeacherDTO teacherDTO = profileTeacherService.getTeacherByUserId(userId);
        model.addAttribute("teacherDTO", teacherDTO);
        List<ProjectDTO> projectDTOList = projectCatalogService.getTeachersProjectByTeacherUserId(userId);
        model.addAttribute("projectsList", projectDTOList);
        return "teacher_profile";
    }

    public String getProfileEditPage(Model model, String cookieHeader) {
        Long userId = authService.getUserIdFromCookie(cookieHeader);
        TeacherDTO teacherDTO = profileTeacherService.getTeacherByUserId(userId);
        model.addAttribute("teacherDTO", teacherDTO);
        return "teacher_profile_edit";
    }

    public String updateTeacherData(String cookieHeader, TeacherDTO teacherDTO) {
        Long userId = authService.getUserIdFromCookie(cookieHeader);
        Teacher oldTeacher = teacherService.findTeacherByUserId(userId);
        Teacher updatedTeacher = TeacherToTeacherDTOConverter.convertNewToOld(oldTeacher, teacherDTO);
        teacherService.save(updatedTeacher);
        return "redirect:/teacher/profile";
    }
}
