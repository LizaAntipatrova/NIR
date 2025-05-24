package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.uiservice.student.ProfileUIStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/profile")
public class ProfileStudentController {
    private final ProfileUIStudentService profileUIStudentService;

    @GetMapping("")
    public String showProfileStudentForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return profileUIStudentService.getStudentProfileForm(model, cookieHeader);
    }
    @GetMapping("/edit")
    public String showProfileEditStudentForm(Model model, @RequestHeader("Cookie") String cookieHeader){
        return profileUIStudentService.getStudentEditProfileForm(model, cookieHeader);
    }




}
