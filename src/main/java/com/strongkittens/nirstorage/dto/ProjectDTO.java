package com.strongkittens.nirstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    private String name;

    private LocalDate publicationDate;

    private MultipartFile file;

    private String description;

    private String keyWords;

    private String teacherName;
    private List<String> authorsNames;

    private Integer grade;

}
