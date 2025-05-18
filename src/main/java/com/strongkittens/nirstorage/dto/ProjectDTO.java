package com.strongkittens.nirstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    private String name;

    private LocalDate publicationDate;

    private byte[] file;

    private String description;

    private String keyWords;

    private String teacherName;
    private List<String> authorsNames;

    private int grade;

}
