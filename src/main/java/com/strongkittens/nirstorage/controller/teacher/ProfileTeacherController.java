package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.uiservice.teacher.ProfileUITeacherService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher/profile")
public class ProfileTeacherController {
    private final ProfileUITeacherService profileUITeacherService;

    @GetMapping("")
    public String showProfileForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return profileUITeacherService.getProfileMainPage(model, cookieHeader);
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return profileUITeacherService.getProfileEditPage(model, cookieHeader);
    }

    @PostMapping("/edit/save")
    public String updateTeacherData(Model model, @RequestHeader("Cookie") String cookieHeader, @ModelAttribute("teacherDTO") TeacherDTO teacherDTO){
        return profileUITeacherService.updateTeacherData(cookieHeader, teacherDTO);
    }

}
