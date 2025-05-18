package com.strongkittens.nirstorage.uiservice;


import com.strongkittens.nirstorage.auth.cookie.SessionCookieProvider;
import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.auth.services.CustomResponse;
import com.strongkittens.nirstorage.data.entity.Role;
import com.strongkittens.nirstorage.dto.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class AuthUITeacherService {

    private final AuthService authService;


    public String getSignInForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "teacher_login";
    }

    public String postSignIn(Model model, UserDTO userDTO, HttpServletResponse response) {
        CustomResponse authResponse = authService.signIn(userDTO);
        SessionCookieProvider.setUpTeacherSessionCookie(response, authResponse.getCookieSessionId());
        return "redirect:/teacher/main/" + authResponse.getUserId();
    }

    public String getSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "teacher_registration";
    }

    public String postSingUpForm(UserDTO userDTO) {
        authService.signUp(userDTO, Role.TEACHER);
        return "teacher_login";
    }
}