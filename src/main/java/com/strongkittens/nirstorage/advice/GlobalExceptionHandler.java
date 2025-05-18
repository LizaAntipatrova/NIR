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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//указывает, что методы данного компонента будут использоваться сразу несколькими контроллерами
@ControllerAdvice
public class GlobalExceptionHandler {

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
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("holy shit");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    //метод для обработки исключений
    @ExceptionHandler(ExistingUserWithThatUsernameException.class)
    public ResponseEntity<CustomErrorResponse> handleExistingUserException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("Existing user");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNonExistingUserException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setError("User not found");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

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

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<CustomErrorResponse> handleJsonMappingException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("error in json mapping when searching for userId");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<CustomErrorResponse> handleJsonProcessingException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("error in json processing when searching for userId");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCookieException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidCookieException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("InvalidCookie");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnregisteredUserException.class)
    public ResponseEntity<CustomErrorResponse> handleUnregisteredUserException(Exception ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError("UnregisteredUser");
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
