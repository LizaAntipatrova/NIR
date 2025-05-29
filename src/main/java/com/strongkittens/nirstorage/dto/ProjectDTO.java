package com.strongkittens.nirstorage.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    private String name;

    private LocalDate publicationDate;

    private MultipartFile file;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDTO that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    private String description;

    private String keyWords;
    private Long teacherId;

    private String teacherName;
    private List<String> authorsNames;

    private Integer grade;

}
