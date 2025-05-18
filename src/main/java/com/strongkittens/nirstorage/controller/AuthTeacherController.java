package com.strongkittens.nirstorage.controller;


import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.UserDTO;
import com.strongkittens.nirstorage.uiservice.AuthUIStudentService;
import com.strongkittens.nirstorage.uiservice.AuthUITeacherService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth/teacher")
public class AuthTeacherController {
    private final AuthService authService;
    private final AuthUITeacherService authUIService;

    //показ формы входа преподавателя
    @GetMapping("/sign-in")
    public String showSignInForm(Model model){
        return authUIService.getSignInForm(model);
    }

    //обработка данных формы входа преподавателя
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("userDTO") UserDTO userDTO, Model model, HttpServletResponse response){
        return authUIService.postSignIn(model, userDTO, response);
    }

    //показ формы регистрации
    @GetMapping("/sign-up")
    public String showSignUpForm(Model model){
        return authUIService.getSignUpForm(model);
    }

    //обработка формы регистрации
    @PostMapping("/sign-up")
    public String signUpTeacher(@ModelAttribute("userDTO") UserDTO userDTO, Model model){
        return authUIService.postSingUpForm(userDTO);
    }


}
