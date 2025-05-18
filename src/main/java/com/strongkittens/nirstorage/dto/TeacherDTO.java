package com.strongkittens.nirstorage.dto;

import com.strongkittens.nirstorage.data.entity.Job;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private Job job;

    private String email;
}
