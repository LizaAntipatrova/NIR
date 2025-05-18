package com.strongkittens.nirstorage.uiservice;


import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.auth.services.CustomResponse;
import com.strongkittens.nirstorage.dto.userDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class AuthUIService {

    private final AuthService authService;

    public String getSignInForm(Model model) {
        model.addAttribute("LoginDTO", new userDTO());
        //TODO: переименовать после Семена
        return "userlogin";
    }

    public String postSignIn(Model model, userDTO userDTO, HttpServletResponse response) {
        CustomResponse authResponse = authService.signIn(userDTO);
        return "redirect:/main/" + authResponse.getUserId();
    }

    public String getSignUpForm(Model model) {
        model.addAttribute("userDTO", new userDTO());
        return "user_registration";
    }
}
