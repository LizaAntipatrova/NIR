package com.strongkittens.nirstorage.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.strongkittens.nirstorage.auth.exceptions.auth.DecodeCredentialsException;
import com.strongkittens.nirstorage.auth.exceptions.auth.InvalidBasicAuthorizationHeaderException;
import com.strongkittens.nirstorage.auth.exceptions.auth.InvalidCookieException;
import com.strongkittens.nirstorage.auth.exceptions.data.ExistingUserWithThatUsernameException;
import com.strongkittens.nirstorage.auth.exceptions.data.UnregisteredUserException;
import com.strongkittens.nirstorage.auth.exceptions.data.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.time.LocalDateTime;

//указывает, что методы данного компонента будут использоваться сразу несколькими контроллерами
@ControllerAdvice
public class GlobalExceptionHandler {

//    private final View error;
//
//    public GlobalExceptionHandler(View error) {
//        this.error = error;
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<CustomErrorResponse> handleException(Exception ex, WebRequest request) {
//        CustomErrorResponse errorResponse = new CustomErrorResponse();
//        errorResponse.setTimestamp(LocalDateTime.now());
//        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        errorResponse.setError("Internal Server Error");
//        errorResponse.setMessage(ex.getMessage());
//        errorResponse.setPath(request.getDescription(false));
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    //
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<CustomErrorResponse> handleException(Exception ex, WebRequest request) {
//        CustomErrorResponse errorResponse = new CustomErrorResponse();
//        errorResponse.setTimestamp(LocalDateTime.now());
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setError("holy shit");
//        errorResponse.setMessage(ex.getMessage());
//        errorResponse.setPath(request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }


    //метод для обработки исключений
    //Авторизация юзера: пользователь с такой почтой уже есть
    @ExceptionHandler(ExistingUserWithThatUsernameException.class)
    public String handleExistingUserException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Пользователь с такой почтой уже существует!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    //Авторизация юзера: пользователь не найден при попытке входа
    @ExceptionHandler(UserNotFoundException.class)
    public String handleNonExistingUserException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setError("Пользователь с такой почтой не найден!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    //Авторизация юзера: логин и пароль не совпадают
    @ExceptionHandler(UnregisteredUserException.class)
    public String handleUnregisteredUserException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setError("Вы ввели неправильный пароль!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    //Авторизация юзера: не используется у елизаветы антипатроновой
    @ExceptionHandler(DecodeCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> handleDecodeCredentialsException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Decode credentials problem");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Авторизация юзера: не исп
    @ExceptionHandler(InvalidBasicAuthorizationHeaderException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidBasicAuthorizationHeaderException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Invalid basic authorization header");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Авторизация юзера: не смаппился json
    @ExceptionHandler(JsonMappingException.class)
    public String handleJsonMappingException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Не смаппился json при попытке достать вас из БД");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    //Авторизация юзера: поломался json
    @ExceptionHandler(JsonProcessingException.class)
    public String handleJsonProcessingException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Поломался json при попытке достать вас из БД");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    @ExceptionHandler(InvalidCookieException.class)
    public String handleInvalidCookieException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Вы пытаетесь войти туда, куда вам нельзя");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    //Сервисы: с фронта пришло что-то недопустимо пустое
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest request, Model model) {

        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Пожалуйста, заполните все обязательные поля, прежде чем нажать на кнопочку!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

    /*
    //Сервисы: на беке не упаковалось DTO
    @ExceptionHandler(ErrorDTOPackingException.class)
    public String handleErrorDTOPackingException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setError("Упс! На беке произошла ошибка. Попробуйте еще раз через 5 минут!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error_login";
    }

    //Сервисы: проблемы с БД
    @ExceptionHandler(ErrorInBDException.class)
    public String handleErrorInBDException(Exception ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorResponse.setError(ex.getMessage());
        errorResponse.setMessage("Error in BD");
        errorResponse.setPath(request.getDescription(false));

        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error_login";
    }*/
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex, WebRequest request, Model model) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        errorResponse.setError("Попробуйте заново через 5 минут!");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("status", errorResponse.getStatus());

        return "error";
    }

}