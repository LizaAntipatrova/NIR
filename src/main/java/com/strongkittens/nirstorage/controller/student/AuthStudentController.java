package com.strongkittens.nirstorage.controller.student;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.UserDTO;
import com.strongkittens.nirstorage.uiservice.student.AuthUIStudentService;
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
@RequestMapping("/auth/student")
public class AuthStudentController {

    private final AuthUIStudentService authUIService;

    //показ формы входа студента
    @GetMapping("/sign-in")
    public String shwoSignInForm(Model model){
        return authUIService.getSignInForm(model);
    }

    //обработка данных формы входа студента
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("userDTO") UserDTO userDTO, HttpServletResponse response){
        return authUIService.postSignIn( userDTO, response);
    }

    //показ формы регистрации
    @GetMapping("/sign-up")
    public String showSignUpForm(Model model){
        return authUIService.getSignUpForm(model);
    }

    //обработка формы регистрации
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("userDTO") UserDTO userDTO){
        return authUIService.postSingUpForm(userDTO);
    }




}
