package com.strongkittens.nirstorage.dto;

import com.strongkittens.nirstorage.data.entity.email.ValidEmail;
import jakarta.validation.constraints.NotNull;

public record LoginDTO(
        @NotNull
        @ValidEmail
        String email,

        @NotNull
        String password
) {
}
