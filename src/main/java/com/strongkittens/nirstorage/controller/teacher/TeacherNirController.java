package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.uiservice.student.LoadProjectUIStudentService;
import com.strongkittens.nirstorage.uiservice.student.MainUIStudentService;
import com.strongkittens.nirstorage.uiservice.teacher.MainUITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher/nir")
public class TeacherNirController {

    private final MainUITeacherService mainUITeacherService;
    private final LoadProjectUIStudentService loadProjectUIStudentService;

    //открыть проект
    @GetMapping()
    public String openProjectForm(@RequestParam("id") Long nirId, Model model, @RequestHeader("Cookie") String cookie) {
        return mainUITeacherService.getProjectForm(nirId, model, cookie);
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



    @PostMapping()
    public String giveGrade(@RequestParam Long id, @ModelAttribute("grade") Integer grade){
        return mainUITeacherService.postGiveGrade(id, grade);
    }
}
