package com.strongkittens.nirstorage.uiservice.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.CreateProjectDTO;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.service.ProjectManagementService;
import com.strongkittens.nirstorage.service.StudentListUlyulyuService;
import com.strongkittens.nirstorage.service.TeacherListUlyulyuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadProjectUIStudentService {
    private final ProjectManagementService projectManagementService;
    private final AuthService authService;
    private final StudentListUlyulyuService studentListUlyulyuService;
    private final TeacherListUlyulyuService teacherListUlyulyuService;

    public String getStudentLoadProjectForm(Model model, String cookie) {

        List<StudentDTO> studentDTOS = studentListUlyulyuService
                .getAllStudentFullNamesExceptAuthorUUUU(authService.getUserIdFromCookie(cookie));

        List<TeacherDTO> teacherDTOS = teacherListUlyulyuService.getAllTeachersFullNamesUUUU();
        CreateProjectDTO createProjectDTO = new CreateProjectDTO();
        createProjectDTO.setAuthorsId(new ArrayList<>());
        model.addAttribute("listStudents", studentDTOS);
        model.addAttribute("listTeachers", teacherDTOS);
        model.addAttribute("createProjectDTO", createProjectDTO);
        return "student_project_load";
    }

    public String postStudentLoadProject(CreateProjectDTO createProjectDTO, String cookie) {
        createProjectDTO.getAuthorsId().add(authService.getUserIdFromCookie(cookie));
        projectManagementService.createProject(createProjectDTO);
        return "redirect:/student/main";
    }

    public MultipartFile downloadFileByProjectId(Long nirId) {
        ProjectDTO projectDTO = projectManagementService.getProjectById(nirId);
        return projectDTO.getFile();
    }

}
