package com.strongkittens.nirstorage.auth.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private Long userId;
    private String cookieSessionId;
}
