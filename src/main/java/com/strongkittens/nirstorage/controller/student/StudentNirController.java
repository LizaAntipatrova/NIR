package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.uiservice.student.LoadProjectUIStudentService;
import com.strongkittens.nirstorage.uiservice.student.MainUIStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/nir")
public class StudentNirController {
    private final ProjectCatalogService projectCatalogService;
    private final MainUIStudentService mainUIStudentService;
    private final LoadProjectUIStudentService loadProjectUIStudentService;


    //открыть проект
    @GetMapping()
    public String openProjectForm(@RequestParam("id") Long nirId, Model model) {
        return mainUIStudentService.getProjectForm(nirId, model);
    }

    //скачать pdf из проекта
    @GetMapping("/download")
    public MultipartFile downloadProjectFile(@RequestParam("id") Long nirId, Model model) {
        return loadProjectUIStudentService.downloadFileByProjectId(nirId, model);
    }
}
