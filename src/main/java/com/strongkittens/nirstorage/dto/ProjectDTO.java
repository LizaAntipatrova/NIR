package com.strongkittens.nirstorage.dto;

import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.data.entity.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    private int grade;

}
