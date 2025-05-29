package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.service.TeacherService;
import com.strongkittens.nirstorage.uiservice.teacher.MainUITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher/main")
public class MainTeacherController {
    private final ProjectCatalogService projectCatalogService;
    private final MainUITeacherService mainUITeacherService;


    @GetMapping("")
    public String showMainTeacherForm(Model model) {
        return mainUITeacherService.getMainTeacherForm(model);
    }

    @PostMapping("/apply-filter")
    public String applyFilter(@ModelAttribute("search") String filter, Model model) {
        return mainUITeacherService.getProjectsBySearch(filter, model);
    }

}
