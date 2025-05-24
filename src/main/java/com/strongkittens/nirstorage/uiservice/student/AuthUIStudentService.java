package com.strongkittens.nirstorage.uiservice.student;


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
public class AuthUIStudentService {

    private final AuthService authService;


    public String getSignInForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "student_login";
    }

    public String postSignIn(UserDTO userDTO, HttpServletResponse response) {
        CustomResponse authResponse = authService.signIn(userDTO);
        SessionCookieProvider.setUpStudentSessionCookie(response, authResponse.getCookieSessionId());
        return "redirect:/student/main";
    }

    public String getSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "student_registration";
    }

    public String postSingUpForm(UserDTO userDTO) {
        authService.signUp(userDTO, Role.STUDENT);
        return "redirect:/auth/student/sign-in";
    }
}
