package com.strongkittens.nirstorage.auth.services.parser;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credential {
    @NotBlank
    String login;
    @NotBlank
    String password;
}
