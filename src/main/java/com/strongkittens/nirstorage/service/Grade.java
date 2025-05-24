package com.strongkittens.nirstorage.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    EXCELLENT(5),
    GOOD(4),
    SATISFACTORY(3),
    BADLY(2),
    TERRIBLY(1);

    private final int gradeValue;
}
