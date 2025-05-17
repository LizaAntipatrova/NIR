package com.strongkittens.nirstorage.dto;

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

    @NotNull
    private String login;       //e-mail посетителя или код сотрудника

    @NotNull
    private String password;

}
