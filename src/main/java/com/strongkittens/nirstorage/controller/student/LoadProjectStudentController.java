package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.dto.CreateProjectDTO;
import com.strongkittens.nirstorage.uiservice.student.LoadProjectUIStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/load")
public class LoadProjectStudentController {
    private final LoadProjectUIStudentService loadProjectUIStudentService;

    @GetMapping
    public String showLoadProjectForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return loadProjectUIStudentService.getStudentLoadProjectForm(model, cookieHeader);
    }

    @PostMapping
    public String loadProject(@ModelAttribute("createProjectDTO")CreateProjectDTO createProjectDTO, @RequestHeader("Cookie") String cookieHeader){
        return loadProjectUIStudentService.postStudentLoadProject(createProjectDTO, cookieHeader);
    }
}
