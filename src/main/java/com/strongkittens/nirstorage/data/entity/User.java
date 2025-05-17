package com.strongkittens.nirstorage.data.entity;

import com.strongkittens.nirstorage.data.entity.email.ValidEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"user\"")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ValidEmail
    private String login;

    @NotBlank
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;


}
