package com.strongkittens.nirstorage.uiservice;


import com.strongkittens.nirstorage.auth.httpresponse.HttpResponse;
import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.auth.services.CustomResponse;
import com.strongkittens.nirstorage.dto.LoginDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class AuthUIService {

    private final AuthService authService;

    public String getSignInForm(Model model) {
        model.addAttribute("LoginDTO", new LoginDTO());
        //TODO: переименовать после Семена
        return "userlogin";
    }

    public String postSignIn(Model model, LoginDTO loginDTO, HttpServletResponse response) {
        CustomResponse authResponse = authService.signIn(loginDTO);
        return "redirect:/main/" + authResponse.getUserId();
    }
}
