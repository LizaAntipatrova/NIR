package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.uiservice.student.MainUIStudentService;
import com.strongkittens.nirstorage.uiservice.teacher.MainUITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class MainStudentController {

    private final ProjectCatalogService projectCatalogService;
    private final MainUIStudentService mainUIStudentService;

    @GetMapping("/main")
    public String showMainStudentForm(Model model) {
        return mainUIStudentService.getMainStudentForm(model);
    }

    @PostMapping("/main/apply-filter")
    public String applyFilter(@ModelAttribute("search") String filter, Model model) {
        return mainUIStudentService.getProjectsBySearch(filter, model);
    }
}
