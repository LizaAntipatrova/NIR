package com.strongkittens.nirstorage.dto;

import com.strongkittens.nirstorage.data.entity.email.ValidEmail;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//на и с фронта
//данные для входа и регистрации
public class LoginDTO {

    private String login;       //e-mail пользователя


    private String password;

}
