package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import com.strongkittens.nirstorage.uiservice.student.LoadProjectUIStudentService;
import com.strongkittens.nirstorage.uiservice.student.MainUIStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public ResponseEntity<byte[]> downloadProjectFile(@RequestParam("id") Long nirId) throws IOException {
        MultipartFile file = loadProjectUIStudentService.downloadFileByProjectId(nirId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(file.getBytes());
    }
}
