package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.data.entity.Job;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.uiservice.teacher.ProfileUITeacherService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher/profile")
public class ProfileTeacherController {
    private final ProfileUITeacherService profileUITeacherService;

    private static final Map<Job, String> JOB_TITLES = new LinkedHashMap<>();

    static {
        JOB_TITLES.put(Job.ASSISTANT, "Ассистент");
        JOB_TITLES.put(Job.ASSOCIATE_PROFESSOR, "Доцент");
        JOB_TITLES.put(Job.SENIOR_LECTURER, "Старший преподаватель");
        JOB_TITLES.put(Job.PROFESSOR, "Профессор");
    }

    @GetMapping("")
    public String showProfileForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return profileUITeacherService.getProfileMainPage(model, cookieHeader);
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        model.addAttribute("jobTitles", JOB_TITLES);
        return profileUITeacherService.getProfileEditPage(model, cookieHeader);
    }
//TODO:сделай выпадающий список для профессий!!!!!
    @PostMapping("/edit/save")
    public String updateTeacherData(Model model, @RequestHeader("Cookie") String cookieHeader, @ModelAttribute("teacherDTO") TeacherDTO teacherDTO){
        return profileUITeacherService.updateTeacherData(cookieHeader, teacherDTO);
    }

}
