package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.uiservice.student.MainUIStudentService;
import com.strongkittens.nirstorage.uiservice.teacher.MainUITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/main")
public class MainStudentController {

    private final ProjectCatalogService projectCatalogService;
    private final MainUIStudentService mainUIStudentService;

    @GetMapping("")
    public String showMainStudentForm(Model model) {
        return mainUIStudentService.getMainStudentForm(model);
    }

    @PostMapping("/apply-filter")
    public String applyFilter(@ModelAttribute("search") String filter, Model model) {
        return mainUIStudentService.getProjectsBySearch(filter, model);
    }

    @GetMapping("/nir")
    public String openProjectForm(@RequestParam("id") Long nirId, Model model) {
        return mainUIStudentService.getProjectForm(nirId, model);
    }

}
