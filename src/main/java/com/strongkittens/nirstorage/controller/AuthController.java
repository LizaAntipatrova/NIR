package com.strongkittens.nirstorage.controller;


import com.strongkittens.nirstorage.auth.httpresponse.HttpResponse;
import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.LoginDTO;
import com.strongkittens.nirstorage.uiservice.AuthUIService;
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
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthUIService authUIService;

    //показ формы входа
    @GetMapping("/sign-in")
    public String shwoSignInForm(Model model){
        return authUIService.getSignInForm(model);
    }

    //обработка данных формы входа
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("userDTO")LoginDTO loginDTO, Model model, HttpServletResponse response){
        return authUIService.postSignIn(model, loginDTO, response);
    }

    //показ формы регистрации
    @GetMapping("/sign-up")
    public String showSignUpForm(Model model){
        return authUIService.getSignUpForm(model);
    }
}
