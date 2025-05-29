package com.strongkittens.nirstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String phone;
    private String group;
    private String email;
}
