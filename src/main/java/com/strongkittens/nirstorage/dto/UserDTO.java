package com.strongkittens.nirstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//на и с фронта
//данные для входа и регистрации
public class UserDTO {

    private String login;       //e-mail пользователя


    private String password;

}
